package com.tmb.testdata;

import com.tmb.entity.LoginDetails;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public final class LoginTestData {

  private static final PodamFactory FACTORY = new PodamFactoryImpl();

  private LoginTestData() {
  }

  public static LoginDetails getValidLoginDetails() {
    return FACTORY.manufacturePojo(LoginDetails.class);
  }
}