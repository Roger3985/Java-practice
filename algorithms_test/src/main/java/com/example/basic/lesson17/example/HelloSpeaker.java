package com.example.basic.lesson17.example;

public class HelloSpeaker implements Hello {
    @Override
    public void hello(String name) {
        System.out.printf("哈囉, %s%n", name);
    }
}
