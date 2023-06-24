package com.tmb.tests.mobile;

import com.tmb.screens.ProductDetailsScreen;
import com.tmb.tests.base.MobileTestSetup;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.appium.ScreenObject.screen;

class AddToCartTest extends MobileTestSetup {

  private final ProductDetailsScreen productDetailsScreen = screen(ProductDetailsScreen.class);

  @Test
  void addAProductToCart() {
    productDetailsScreen
        .selectProduct()
        .checkWhetherAddToCartButtonIsPresent();
  }
}