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
    "file:${user.dir}/src/test/resources/staging-config.properties",
})
public interface FrameworkConfig extends Config {

  @DefaultValue("staging")
  String environment();

  @Key("${environment}.url")
  String webURL();

}