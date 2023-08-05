package com.tmb.entity.strategy;

import com.github.javafaker.Faker;
import uk.co.jemos.podam.common.AttributeStrategy;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.IntStream;

public class FirstNameStrategy implements AttributeStrategy<String> {
  @Override
  public String getValue(Class<?> aClass, List<Annotation> list) {
    Faker faker = new Faker();
    return IntStream.rangeClosed(1, 100)
      .mapToObj(i -> faker.name().firstName())
      .findAny()
      .orElseThrow();
  }
}
