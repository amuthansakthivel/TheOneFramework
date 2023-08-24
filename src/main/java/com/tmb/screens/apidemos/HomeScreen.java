package com.tmb.screens.apidemos;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$x;

public class HomeScreen {

  private static final String VIEWS = "//*[@text='Views']";

  public ViewsScreen navigateToViewsScreen() {
    $x(VIEWS).shouldBe(visible).click();
    return screen(ViewsScreen.class);
  }
}

