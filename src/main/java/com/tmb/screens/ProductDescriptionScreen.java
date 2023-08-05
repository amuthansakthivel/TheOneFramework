package com.tmb.screens;

import com.codeborne.selenide.appium.selector.CombinedBy;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductDescriptionScreen {

  @AndroidFindBy(accessibility = "Add To Cart button")
  @iOSXCUITFindBy(iOSNsPredicate = "label == 'Add To Cart'")
  private WebElement addToCart;

  //CombinedBy is an alternative to PageFactory. When you want to have dynamic element, CombinedBy can be really helpful
  private static final CombinedBy ADD_TO_CART_BUTTON = CombinedBy.android(AppiumBy.accessibilityId("Add To Cart button"))
    .ios(AppiumBy.iOSNsPredicateString("label == 'Add To Cart'"));

  public void checkWhetherAddToCartButtonIsPresent() {
    $(ADD_TO_CART_BUTTON).shouldHave(visible);
  }

}
