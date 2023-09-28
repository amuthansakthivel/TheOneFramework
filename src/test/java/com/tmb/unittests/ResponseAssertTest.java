package com.tmb.unittests;


import com.tmb.asserthelpers.ResponseAssert;
import com.tmb.entity.requests.UserDetails;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ResponseAssertTest {

    Response responseMock = mock(Response.class);

    @Test
    void assertThatReturnResponseAssert() {
        Assertions.assertThat(ResponseAssert.assertThat(responseMock))
                .isInstanceOf(ResponseAssert.class)
                .isNotNull();
    }

    @Test
    void statusCode() {
        when(responseMock.statusCode()).thenReturn(200);
        ResponseAssert.assertThat(responseMock)
                .statusCodeIs(200)
                .assertAll();

        verify(responseMock, times(1)).statusCode();
    }

    @Test
    void contentType() {
        when(responseMock.getContentType()).thenReturn("application/json");
        ResponseAssert.assertThat(responseMock)
                .contentTypeIs(ContentType.JSON)
                .assertAll();
    }

    @Test
    void matchingRule() {
        JsonPath jsonPathMock = mock(JsonPath.class);
        when(responseMock.jsonPath()).thenReturn(jsonPathMock);
        when(jsonPathMock.getString("job")).thenReturn("testing");
        ResponseAssert.assertThat(responseMock)
                .matchingRule(e -> e.jsonPath().getString("job").equalsIgnoreCase("testing"))
                .assertAll();
    }

    @Test
    void responseDeserializedCorrectlyWhenPassingCorrectDeserializerClass() {
        when(responseMock.as(UserDetails.class)).thenReturn(new UserDetails());
        ResponseAssert.assertThat(responseMock)
                .canBeDeserializedTo(UserDetails.class)
                .assertAll();
    }

    @Test
    void responseDeserializationThrowsExceptionOnIncorrectDeserializerClass() {
        when(responseMock.as(UserDetails.class)).thenThrow(AssertionError.class);
        ResponseAssert responseAssert = ResponseAssert.assertThat(responseMock);
        org.junit.jupiter.api.Assertions.assertThrows(AssertionError.class, () -> responseAssert.
                canBeDeserializedTo(UserDetails.class).assertAll());
    }

    @Test
    void hasKeyWithValue() {
        JsonPath jsonPathMock = mock(JsonPath.class);
        when(responseMock.jsonPath()).thenReturn(jsonPathMock);
        when(jsonPathMock.getString("job")).thenReturn("testing");
        ResponseAssert.assertThat(responseMock)
                .hasKeyWithValue("job", "testing")
                .assertAll();
    }

    @Test
    void containsValue() {
        ResponseBody responseBody = mock(ResponseBody.class);
        when(responseMock.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn("Testing in progress");
        ResponseAssert.assertThat(responseMock)
                .contains("progress")
                .assertAll();
    }

    @Test
    void doesNotContainsValue() {
        ResponseBody responseBody = mock(ResponseBody.class);
        when(responseMock.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn("Testing in progress");
        ResponseAssert.assertThat(responseMock)
                .doesNotContains("hello")
                .assertAll();
    }

    @Test
    void matchSchemaInFile() {
        String responseString = "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 2,\n" +
                "        \"email\": \"janet.weaver@reqres.in\",\n" +
                "        \"first_name\": \"Janet\",\n" +
                "        \"last_name\": \"Weaver\",\n" +
                "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
                "    },\n" +
                "    \"support\": {\n" +
                "        \"url\": \"https://reqres.in/#support-heading\",\n" +
                "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                "    }\n" +
                "}";
        ResponseBody responseBody = mock(ResponseBody.class);
        when(responseMock.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn(responseString);

        ResponseAssert.assertThat(responseMock)
                .matchesSchemaInFile("get-user-response-schema.json")
                .assertAll();
    }
}