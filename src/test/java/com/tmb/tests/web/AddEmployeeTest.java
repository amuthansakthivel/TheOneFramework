package com.tmb.tests.web;

import com.tmb.entity.EmployeeDetails;
import com.tmb.entity.LoginDetails;
import com.tmb.pages.LoginPage;
import com.tmb.testdata.EmployeeTestData;
import com.tmb.testdata.LoginTestData;
import com.tmb.tests.base.WebTestSetup;
import org.junit.jupiter.api.Test;

class AddEmployeeTest extends WebTestSetup {

  private final EmployeeDetails employeeDetails = EmployeeTestData.getRandomEmployeeDetails();
  private final LoginDetails loginDetails = LoginTestData.getValidLoginDetails();

  @Test
  void testAddEmployee() {
    LoginPage.getInstance()
        .loginToApplication(loginDetails)
        .navigateToEmployeeInformationPage()
        .addNewEmployee(employeeDetails)
        .checkWhetherEmployeeCreatedSuccessfully();
  }
}