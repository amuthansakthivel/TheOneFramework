package com.tmb.asserthelpers;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

import java.io.File;
import java.util.function.Predicate;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {
  private final String DEFAULT_SCHEMA_PATH = String.format("%s/src/test/resources/schemas/", System.getProperty("user.dir"));
  private final SoftAssertions softAssertions;

  private ResponseAssert(Response response) {
    super(response, ResponseAssert.class);
    softAssertions = new SoftAssertions();
  }

  public static ResponseAssert assertThat(Response response) {
    return new ResponseAssert(response);
  }

  public ResponseAssert statusCodeIs(int statusCode) {
    softAssertions.assertThat(actual.statusCode())
      .isEqualTo(statusCode);
    return this;
  }

  public ResponseAssert contentTypeIs(ContentType contentType) {
    softAssertions
      .assertThat(actual.getContentType())
      .as("Content Type validation")
      .isEqualTo(contentType.toString());
    return this;
  }

  public ResponseAssert matchingRule(Predicate<Response> condition, String errorMessage) {
    softAssertions.assertThat(condition).withFailMessage(errorMessage).accepts(actual);
    return this;
  }

  public ResponseAssert matchingRule(Predicate<Response> condition) {
    return matchingRule(condition, "Predicate validation failed");
  }

  public <T> ResponseAssert canBeDeserializedTo(Class<T> clazz) {
    softAssertions
      .assertThatCode(() -> actual.as(clazz))
      .withFailMessage("Response cannot be deserialized to " + clazz.getName())
      .doesNotThrowAnyException();
    return this;
  }

  public ResponseAssert hasKeyWithValue(String key, String expectedValue) {
    String actualValue = actual.jsonPath().getString(key);
    softAssertions
      .assertThat(actualValue)
      .as("body node validation in response")
      .contains(expectedValue);
    return this;
  }

  public ResponseAssert contains(String value) {
    softAssertions
      .assertThat(actual.body().asString())
      .as("Body node validation in response")
      .contains(value);
    return this;
  }

  public ResponseAssert doesNotContains(String value) {
    softAssertions
      .assertThat(actual.body().asString())
      .as("Body node validation in response")
      .doesNotContain(value);
    return this;
  }

  public ResponseAssert matchesSchemaInFile(String schemaFileName) {
    File file = FileUtils.getFile(DEFAULT_SCHEMA_PATH + schemaFileName);
    softAssertions
      .assertThat(JsonSchemaValidator.matchesJsonSchema(file).matches(actual.body().asString()))
      .as("Response schema validation: ")
      .isTrue();
    return this;
  }

  public void assertAll() {
    softAssertions.assertAll();
  }
}
