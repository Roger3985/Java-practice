package com.example.basic.lesson18.example.annotation;

public @interface Test4 {
    int timeout() default 0;
    String message() default "";
}
