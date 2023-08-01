package com.tmb.tests.mobile;

import com.tmb.screens.ProductDetailsScreen;
import com.tmb.tags.MobileTest;
import com.tmb.tags.RegressionTest;
import com.tmb.tests.base.MobileTestSetup;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@RegressionTest
class AddToCartTest extends MobileTestSetup {

    @MobileTest
    void addAProductToCart() {
        ProductDetailsScreen productDetailsScreen = screen(ProductDetailsScreen.class);

        productDetailsScreen
                .selectProduct()
                .checkWhetherAddToCartButtonIsPresent();
    }
}