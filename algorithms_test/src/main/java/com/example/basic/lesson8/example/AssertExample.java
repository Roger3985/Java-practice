package com.example.basic.lesson8.example;

public class AssertExample {
    public static void main(String[] args) {
        int x = -2;
        if (x > 0) throw new AssertionError("x must be positive"); // 如果 x <= 0，會拋出帶消息的 AssertionError
        System.out.println("Assertion passed");
    }
}
