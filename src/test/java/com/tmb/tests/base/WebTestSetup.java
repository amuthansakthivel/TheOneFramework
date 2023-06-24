package com.tmb.tests.base;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class WebTestSetup extends TestSetup {

  @BeforeEach
  void setUp() {
    open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
}