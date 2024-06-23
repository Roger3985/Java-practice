package com.example.basic.lesson17.example;

import static java.lang.System.out;

public class ClassInfo {
    public static void main(String[] args) {
        Class clz = String.class;

        out.printf("類別名稱：%s%n", clz.getName());
        out.printf("所在模組：%s%n", clz.getModule().getName());
    }
}
