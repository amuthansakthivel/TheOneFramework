package com.tmb.tests.base;

import com.codeborne.selenide.Configuration;
import com.tmb.config.FrameworkConfig;
import com.tmb.config.factory.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class WebTestSetup extends TestSetup {

  private static final FrameworkConfig CONFIG = ConfigFactory.config();
  private static final String URL = CONFIG.webURL();

  @BeforeEach
  void setUp() {
    Configuration.headless = false;
    open(URL);
  }
}