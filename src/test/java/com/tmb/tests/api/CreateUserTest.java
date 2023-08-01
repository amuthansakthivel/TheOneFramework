package com.tmb.tests.api;

import com.tmb.api.CreateUserApi;
import com.tmb.entity.UserDetails;
import com.tmb.tags.ApiTest;
import com.tmb.tags.SmokeTest;
import com.tmb.testdata.UserTestData;
import com.tmb.tests.base.ApiTestSetUp;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

class CreateUserTest extends ApiTestSetUp {

    private final UserDetails userDetails = UserTestData.getUserDetails();

    @ApiTest
    void createUser() {
        Response response = CreateUserApi.createUser(userDetails);
        assertThat(response.statusCode())
                .isEqualTo(201);
    }
}