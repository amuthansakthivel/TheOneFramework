package com.tmb.tests.mobile;

import com.tmb.screens.apidemos.HomeScreen;
import com.tmb.tags.testtype.ApiDemosMobileTest;
import com.tmb.tests.base.MobileTestSetup;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@ApiDemosMobileTest
class ScrollToElementTest extends MobileTestSetup {

  @Test
  void scroll() {
    HomeScreen homeScreen = screen(HomeScreen.class);

    homeScreen.navigateToViewsScreen()
      .checkWhetherWebViewIsDisplayedInBottomOfScreen();
  }
}
