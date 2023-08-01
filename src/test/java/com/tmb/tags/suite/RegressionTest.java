package com.tmb.tags.suite;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.*;

//including all smoke tests by default in regression tag
@Tag("regression")
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@SmokeTest
public @interface RegressionTest {
}