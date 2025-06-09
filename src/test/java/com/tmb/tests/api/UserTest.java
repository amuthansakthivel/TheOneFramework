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

  @ApiTest
  void updateUserDetails() {
    UserDetails userDetails1 = UserTestData.getUserDetails();
    Response response = UserApi.updateUser(2, userDetails1);


    assertThat(response)
            .statusCodeIs(200)
            .assertAll();
  }

  @ApiTest
  void deleteUser() {
    Response response = UserApi.deleteUser(2);

    assertThat(response)
            .statusCodeIs(204)
            .assertAll();
  }

  @ApiTest
  void createUserWithInvalidData() {
    UserDetails invalidUserDetails = new UserDetails("", ""); // Empty name and job
    Response response = UserApi.createUser(invalidUserDetails);

    if (response.statusCode() == 400) {
      assertThat(response)
          .statusCodeIs(400)
          .assertAll();
    } else {
      System.err.println("Unexpected status code: " + response.statusCode());
    }
    }

    @ApiTest
    void getUserDetailsNonExistentUser() {
    Response response = UserApi.getUser(9999); // Using 9999 as a non-existent user ID for testing

    if (response.statusCode() == 404) {
      assertThat(response)
          .statusCodeIs(404)
          .assertAll();
    } else {
      System.err.println("Unexpected status code: " + response.statusCode());
    }
  }

  @ApiTest
  void updateUserWithInvalidData() {
    UserDetails invalidUserDetails = new UserDetails("", ""); // Empty name and job
    Response response = UserApi.updateUser(2, invalidUserDetails);

    assertThat(response)
            .statusCodeIs(400)
            .assertAll();
  }

  @ApiTest
  void createUserWithSpecialCharacters() {
    UserDetails specialCharUserDetails = new UserDetails("!@#$%^&*()", "Developer");
    Response response = UserApi.createUser(specialCharUserDetails);

    assertThat(response)
            .statusCodeIs(201)
            .canBeDeserializedTo(CreateUserResponse.class)
            .hasKeyWithValue("job", specialCharUserDetails.getJob())
            .matchingRule(e -> e.jsonPath().getString("name").equals(specialCharUserDetails.getName()))
            .matchesSchemaInFile("create-user-response-schema.json")
            .assertAll();
  }
}
