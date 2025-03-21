package com.tmb.api;


import com.tmb.entity.requests.UserDetails;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {
    private UserApi() {
    }

    public static Response createUser(UserDetails userDetails) {
        return given()
                .body(userDetails)
                .contentType(ContentType.JSON)
                .post("/api/users");
    }

    public static Response getUser(int userId) {
        return given()
                .pathParam("userId", userId)
                .get("/api/users/{userId}");
    }

    public static Response updateUser(int userId, UserDetails userDetails) {
        return given()
                .pathParam("userId", userId)
                .body(userDetails)
                .put("/api/users/{userId}");
    }

        public static Response deleteUser(int userId) {
        return  given()
                .pathParam("userId", userId)
                .when()
                .delete("/users/{userId}");
    }
}
