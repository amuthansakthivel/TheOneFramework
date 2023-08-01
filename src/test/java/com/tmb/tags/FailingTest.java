package com.tmb.tags;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.*;

@Tag("failing")
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface FailingTest {
}