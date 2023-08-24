package com.tmb.screens.apidemos;

import com.codeborne.selenide.appium.AppiumScrollOptions;
import com.codeborne.selenide.appium.AppiumSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ViewsScreen {

  private static final By WEBVIEW = AppiumSelectors.byContentDescription("WebView");

  public void checkWhetherWebViewIsDisplayedInBottomOfScreen() {
    $(WEBVIEW).scroll(AppiumScrollOptions.down()).shouldBe(visible);
  }
}
