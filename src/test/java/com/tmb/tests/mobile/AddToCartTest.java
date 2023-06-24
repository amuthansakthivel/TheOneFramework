package com.tmb.tests.mobile;

import com.tmb.screens.ProductDetailsScreen;
import com.tmb.tests.base.MobileTestSetup;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Tag("mobile")
class AddToCartTest extends MobileTestSetup {

  @Test
  void addAProductToCart() {
    ProductDetailsScreen productDetailsScreen = screen(ProductDetailsScreen.class);

    productDetailsScreen
        .selectProduct()
        .checkWhetherAddToCartButtonIsPresent();
  }
}