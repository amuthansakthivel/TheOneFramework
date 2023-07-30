package com.tmb.entity.strategy;

import uk.co.jemos.podam.common.AttributeStrategy;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public class JobStrategy implements AttributeStrategy<String> {

    @Override
    public String getValue(Class<?> aClass, List<Annotation> list) {
        return Stream.of("developer","tester","devops","SRE")
                .findAny()
                .orElseThrow();
    }
}