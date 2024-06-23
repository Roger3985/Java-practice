package com.example.basic.lesson18.example.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Filters.class)
public @interface Filter {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Filters {
    Filter[] value();
}
