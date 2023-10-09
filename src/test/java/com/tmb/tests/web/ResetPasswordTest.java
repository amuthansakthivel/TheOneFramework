package com.tmb.tests.web;

import com.tmb.pages.LoginPage;
import com.tmb.tags.suite.RegressionTest;
import com.tmb.tags.testtype.WebTest;
import com.tmb.tests.base.WebTestSetup;

@RegressionTest
class ResetPasswordTest extends WebTestSetup {

  @WebTest
  void resetPassword1() {
    LoginPage.getInstance()
            .navigateToResetPasswordPage()
            .resetPassword()
            .checkWhetherPasswordResetMessageIsDisplayed();
  }
  @WebTest
  void resetPassword2() {
    LoginPage.getInstance()
            .navigateToResetPasswordPage()
            .resetPassword()
            .checkWhetherPasswordResetMessageIsDisplayed();
  }
  @WebTest
  void resetPassword3() {
    LoginPage.getInstance()
            .navigateToResetPasswordPage()
            .resetPassword()
            .checkWhetherPasswordResetMessageIsDisplayed();
  }
  @WebTest
  void resetPassword4() {
    LoginPage.getInstance()
            .navigateToResetPasswordPage()
            .resetPassword()
            .checkWhetherPasswordResetMessageIsDisplayed();
  }
  @WebTest
  void resetPassword5() {
    LoginPage.getInstance()
            .navigateToResetPasswordPage()
            .resetPassword()
            .checkWhetherPasswordResetMessageIsDisplayed();
  }
  @WebTest
  void resetPassword6() {
    LoginPage.getInstance()
            .navigateToResetPasswordPage()
            .resetPassword()
            .checkWhetherPasswordResetMessageIsDisplayed();
  }
}
