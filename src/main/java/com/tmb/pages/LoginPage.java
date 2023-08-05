package com.tmb.pages;

import com.codeborne.selenide.SelenideElement;
import com.tmb.entity.LoginDetails;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
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

  public HomePage loginToApplication(LoginDetails loginDetails) {
    USERNAME.shouldBe(visible)
      .setValue(loginDetails.getUserName());
    PASSWORD.shouldBe(visible)
      .setValue(loginDetails.getPassword());
    LOGIN_BUTTON.shouldBe(enabled)
      .click();
    return new HomePage();
  }
}
