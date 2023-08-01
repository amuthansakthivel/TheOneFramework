package com.tmb.api;


import com.tmb.entity.UserDetails;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateUserApi {
    private CreateUserApi() {
    }

    public static Response createUser(UserDetails userDetails) {
        return given()
                .body(userDetails)
                .contentType(ContentType.JSON)
                .post("/api/users");
    }
}