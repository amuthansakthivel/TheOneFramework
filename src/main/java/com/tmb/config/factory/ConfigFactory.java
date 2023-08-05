package com.tmb.config.factory;

import com.tmb.config.FrameworkConfig;
import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {

  private ConfigFactory() {
  }

  public static FrameworkConfig config() {
    return ConfigCache.getOrCreate(FrameworkConfig.class);
  }

}
