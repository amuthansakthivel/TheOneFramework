package com.tmb.pages;

import com.codeborne.selenide.SelenideElement;
import com.tmb.entity.LoginDetails;

import java.time.Duration;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

  private LoginPage() {
  }

  public static LoginPage getInstance() {
    return new LoginPage();
  }

  private static final SelenideElement USERNAME = $(byName("username"));
  private static final SelenideElement PASSWORD = $(byAttribute("placeholder", "Password"));
  private static final SelenideElement LOGIN_BUTTON = $("[type='submit']");
  private static final SelenideElement FORGOT_YOUR_PASSWORD = $(withText("Forgot your"));

  public HomePage loginToApplication(LoginDetails loginDetails) {
    USERNAME.shouldBe(visible)
            .setValue(loginDetails.getUserName());
    PASSWORD.shouldBe(visible)
            .setValue(loginDetails.getPassword());
    LOGIN_BUTTON.shouldBe(enabled)
            .click();
    return new HomePage();
  }

  public ResetPasswordPage navigateToResetPasswordPage() {
    FORGOT_YOUR_PASSWORD.shouldBe(interactable, Duration.ofSeconds(30)).click(usingJavaScript());
    return new ResetPasswordPage();
  }
}
