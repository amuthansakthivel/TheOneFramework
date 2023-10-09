package com.tmb.tests.api;

import com.tmb.api.UserApi;
import com.tmb.entity.response.CreateUserResponse;
import com.tmb.entity.requests.UserDetails;
import com.tmb.tags.testtype.ApiTest;
import com.tmb.tags.suite.RegressionTest;
import com.tmb.testdata.UserTestData;
import com.tmb.tests.base.ApiTestSetUp;
import io.restassured.response.Response;

import static com.tmb.asserthelpers.ResponseAssert.*;

//@RegressionTest
class UserTest extends ApiTestSetUp {

  private final UserDetails userDetails = UserTestData.getUserDetails();

  @ApiTest
  void createUser() {

    Response response = UserApi.createUser(userDetails);

    assertThat(response)
            .statusCodeIs(201)
            .canBeDeserializedTo(CreateUserResponse.class)
            .hasKeyWithValue("job", userDetails.getJob())
            .matchingRule(e -> e.jsonPath().getString("name").equalsIgnoreCase(userDetails.getName()))
            .matchesSchemaInFile("create-user-response-schema.json")
            .assertAll(); //don't forget to call assertAll
  }

  @ApiTest
  void getUserDetails() {
    Response response = UserApi.getUser(2);

    assertThat(response)
            .statusCodeIs(200)
            .matchesSchemaInFile("get-user-response-schema.json")
            .matchingRule(response1 ->
                    response1.jsonPath().getString("data.email").equalsIgnoreCase("janet.weaver@reqres.in"))
            .assertAll();
  }
}
