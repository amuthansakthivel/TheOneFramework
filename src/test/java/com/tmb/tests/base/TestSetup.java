package com.tmb.tests.base;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestSetup {

  @BeforeAll
  static void setupAllureReports() {
    //Logs element interaction steps to the allure report
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    //Logs request and response details for API calls to the allure report
    RestAssured.filters(new AllureRestAssured());
  }
}