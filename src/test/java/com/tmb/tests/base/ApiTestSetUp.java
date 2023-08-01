package com.tmb.tests.base;

import com.tmb.config.FrameworkConfig;
import com.tmb.config.factory.ConfigFactory;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class ApiTestSetUp extends TestSetup {

    private static final FrameworkConfig CONFIG = ConfigFactory.config();

    @BeforeEach
    void apiSetUp() {
        RestAssured.baseURI = CONFIG.apiBaseUrl();
    }
}