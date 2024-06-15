package com.example.basic.lesson8.example;

public class StackTraceDemo2 {
    public static void main(String[] args) {
        try {
            c();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    static void c() {
        try {
            b();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            Throwable t = ex.fillInStackTrace(); // fillInStackTrace() -> 讓例外堆疊起點為重拋例外的地方。
            throw (NullPointerException) t;
        }
    }

    static void b() {
        a();
    }

    static String a() {
        String text = null;
        return text.toUpperCase();
    }
}
