package com.tmb.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductDescriptionScreen {

  @AndroidFindBy(accessibility = "Add To Cart button")
  @iOSXCUITFindBy(iOSNsPredicate = "label == 'Add To Cart'")
  private WebElement addToCart;

  public void checkWhetherAddToCartButtonIsPresent() {
    $(addToCart).shouldHave(visible);
  }

}