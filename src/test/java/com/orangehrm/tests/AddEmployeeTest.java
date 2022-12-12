package com.orangehrm.tests;

import com.orangehrm.entity.EmployeeDetails;
import com.orangehrm.entity.LoginDetails;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.testdata.EmployeeTestData;
import com.orangehrm.testdata.LoginTestData;
import com.orangehrm.tests.base.TestSetup;
import org.junit.jupiter.api.Test;

class AddEmployeeTest extends TestSetup {

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