package com.tmb.tests.api;

import com.tmb.api.CreateUserApi;
import com.tmb.entity.response.CreateUserResponse;
import com.tmb.entity.requests.UserDetails;
import com.tmb.tags.testtype.ApiTest;
import com.tmb.tags.suite.RegressionTest;
import com.tmb.testdata.UserTestData;
import com.tmb.tests.base.ApiTestSetUp;
import io.restassured.response.Response;

import static com.tmb.asserthelpers.ResponseAssert.*;

@RegressionTest
class CreateUserTest extends ApiTestSetUp {

  private final UserDetails userDetails = UserTestData.getUserDetails();

  @ApiTest
  void createUser() {
    Response response = CreateUserApi.createUser(userDetails);

    assertThat(response)
      .statusCodeIs(201)
      .canBeDeserializedTo(CreateUserResponse.class)
      .hasKeyWithValue("job", userDetails.getJob())
      .matchingRule(e -> e.jsonPath().getString("name").equalsIgnoreCase(userDetails.getName()))
      .matchesSchemaInFile("create-user-response-schema.json")
      .assertAll(); //don't forget to call assertAll
  }
}
