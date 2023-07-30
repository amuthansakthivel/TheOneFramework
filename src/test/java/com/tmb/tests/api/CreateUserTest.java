package com.tmb.tests.api;

import com.tmb.api.CreateUserApi;
import com.tmb.entity.UserDetails;
import com.tmb.testdata.UserTestData;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("api")
class CreateUserTest extends ApiTestSetUp {

    private final UserDetails userDetails = UserTestData.getUserDetails();

    @Test
    void createUser() {
        Response response = CreateUserApi.createUser(userDetails);
        assertThat(response.statusCode())
                .isEqualTo(201);
    }
}