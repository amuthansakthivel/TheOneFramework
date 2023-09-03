package com.tmb.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ResetPasswordPage {

    private static final SelenideElement USERNAME = $(byAttribute("placeholder", "Username"));
    private static final SelenideElement RESET_PASSWORD = $x("//button[@type='submit']");
    private static final SelenideElement RESET_SUCCESS_MESSAGE = $x("//h6");

    public ResetPasswordPage resetPassword() {
        USERNAME.shouldBe(visible).setValue("Admin");
        RESET_PASSWORD.shouldBe(visible).click();
        return this;
    }

    public void checkWhetherPasswordResetMessageIsDisplayed() {
        RESET_SUCCESS_MESSAGE.shouldHave(text("Reset Password link sent successfully"));
    }
}