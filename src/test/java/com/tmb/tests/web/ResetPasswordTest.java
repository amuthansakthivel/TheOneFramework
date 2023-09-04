package com.tmb.tests.web;

import com.tmb.pages.LoginPage;
import com.tmb.tags.testtype.WebTest;
import com.tmb.tests.base.WebTestSetup;

class ResetPasswordTest extends WebTestSetup {

  @WebTest
  void resetPassword() {
    LoginPage.getInstance()
            .navigateToResetPasswordPage()
            .resetPassword()
            .checkWhetherPasswordResetMessageIsDisplayed();
  }
}