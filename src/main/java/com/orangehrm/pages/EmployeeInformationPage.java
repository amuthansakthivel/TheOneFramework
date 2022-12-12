package com.orangehrm.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.orangehrm.entity.EmployeeDetails;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EmployeeInformationPage {

  private static final SelenideElement ADD_EMPLOYEE_BUTTON = $(byTagAndText("a", "Add Employee"));
  private static final SelenideElement FIRST_NAME = $(byName("firstName"));
  private static final SelenideElement LAST_NAME = $(byName("lastName"));
  private static final SelenideElement MIDDLE_NAME = $(byName("middleName"));
  private static final SelenideElement SAVE_BUTTON = $(byText("Save"));
  private static final SelenideElement IMAGE = $(byXpath("//input[@type='file']"));
  private static final ElementsCollection SUCCESS_MESSAGE = $$(byText("Success"));

  public EmployeeInformationPage addNewEmployee(EmployeeDetails employee){
    ADD_EMPLOYEE_BUTTON.shouldBe(visible).click();
    FIRST_NAME.shouldBe(visible).setValue(employee.getFirstName());
    LAST_NAME.shouldBe(visible).setValue(employee.getLastName());
    MIDDLE_NAME.shouldBe(visible).setValue(employee.getMiddleName());
    IMAGE.shouldBe(enabled).uploadFromClasspath(employee.getProfilePicturePath());
    SAVE_BUTTON.shouldBe(enabled).click();
    return this;
  }

  public void checkWhetherEmployeeCreatedSuccessfully(){
    SUCCESS_MESSAGE.first().shouldHave(visible, text("Success"));
  }
}