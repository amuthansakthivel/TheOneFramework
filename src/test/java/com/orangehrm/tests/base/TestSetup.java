package com.orangehrm.tests.base;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestSetup {

  @BeforeAll
  static void setupAllureReports() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }

  @BeforeEach
  void setUp() {
    open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
}