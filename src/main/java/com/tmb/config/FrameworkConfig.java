package com.tmb.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadPolicy;
import static org.aeonbits.owner.Config.LoadType;
import static org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({
    "system:properties",
    "system:env",
    "file:${user.dir}/src/test/resources/config.properties",
    "file:${user.dir}/src/test/resources/dev-config.properties",
    "file:${user.dir}/src/test/resources/staging-config.properties",
})
public interface FrameworkConfig extends Config {

  @DefaultValue("staging")
  String environment();

  @Key("${environment}.url")
  String webURL();

  @Key("${environment}.api.baseurl")
  String apiBaseUrl();

  String lambdaTestAppUrl();

  String lambdaTestUserName();

  String lambdaTestAccessKey();

  @Key("https://${lambdaTestUserName}:${lambdaTestAccessKey}@mobile-hub.lambdatest.com/wd/hub")
  String lambdaTestRemoteUrl();

}