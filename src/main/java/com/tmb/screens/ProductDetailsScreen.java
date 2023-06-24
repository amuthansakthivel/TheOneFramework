package com.tmb.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;

public class ProductDetailsScreen {

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"store item\"]")
  @iOSXCUITFindBy(xpath = "//*[@name='store item text']")
  private WebElement product;

  public ProductDescriptionScreen selectProduct() {
    $(product).shouldBe(visible).click();
    return screen(ProductDescriptionScreen.class);
  }
}