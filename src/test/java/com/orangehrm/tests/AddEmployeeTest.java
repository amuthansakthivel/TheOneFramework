package com.orangehrm.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.orangehrm.entity.EmployeeDetails;
import com.orangehrm.pages.EmployeeInformationPage;
import com.orangehrm.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static com.codeborne.selenide.Selenide.open;

class AddEmployeeTest {

  private PodamFactory factory = new PodamFactoryImpl();

  @Test
  void testAddEmployee() {
    EmployeeDetails employee = factory.manufacturePojo(EmployeeDetails.class);
    open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    new LoginPage()
        .loginToApplication()
        .getLeftMenuComponent()
        .selectAMenuFromLeftMenuBar("PIM");

    new EmployeeInformationPage()
        .addNewEmployee(employee)
        .checkWhetherEmployeeCreatedSuccessfully();

  }
}