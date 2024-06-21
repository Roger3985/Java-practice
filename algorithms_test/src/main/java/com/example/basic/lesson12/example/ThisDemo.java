package com.example.basic.lesson12.example;

import static java.lang.System.out;

class Hello {
    Runnable r1 = () -> out.println(this);
    Runnable r2 = () -> out.println(toString());

    public String toString() {
        return "Hello, World!";
    }
}

public class ThisDemo {
    public static void main(String[] args) {
        var hello = new Hello();
        hello.r1.run();
        hello.r2.run();
    }
}
