package com.orangehrm.pages.pagecomponents;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LeftMenuComponent {

  public void selectAMenuFromLeftMenuBar(String menuName){
    $(byText(menuName)).shouldBe(enabled).click();
  }
}