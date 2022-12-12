package com.orangehrm.testdata;

import com.orangehrm.entity.EmployeeDetails;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public final class EmployeeTestData {

  private static final PodamFactory FACTORY = new PodamFactoryImpl();

  private EmployeeTestData() {
  }

  public static EmployeeDetails getRandomEmployeeDetails() {
    return FACTORY.manufacturePojo(EmployeeDetails.class);
  }
}