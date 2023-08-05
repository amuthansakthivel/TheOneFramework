package com.tmb.testdata;

import com.tmb.entity.requests.UserDetails;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class UserTestData {
  private static final PodamFactory FACTORY = new PodamFactoryImpl();

  private UserTestData() {
  }

  public static UserDetails getUserDetails() {
    return FACTORY.manufacturePojo(UserDetails.class);
  }
}
