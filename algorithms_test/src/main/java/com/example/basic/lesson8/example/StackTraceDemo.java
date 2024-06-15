package com.example.basic.lesson8.example;

public class StackTraceDemo {
    public static void main(String[] args) {
        try {
            c();
        } catch (NullPointerException ex) {
            ex.getStackTrace(); // 取得個別的堆疊追蹤元素進行處理 -> 前提是不能可有私吞例外的行為
        }
    }

    static void c() {
        b();
    }

    static void b() {
        a();
    }

    static String a() {
        String text = null;
        return text.toUpperCase();
    }
}
