package com.tmb.tests.base;

import com.codeborne.selenide.appium.SelenideAppium;
import org.junit.jupiter.api.BeforeEach;

public class MobileTestSetup extends TestSetup {

  @BeforeEach
  public void launchApp() {
    SelenideAppium.launchApp();
  }
}