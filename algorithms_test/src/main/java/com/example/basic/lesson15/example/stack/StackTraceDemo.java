package com.example.basic.lesson15.example.stack;

import java.util.List;

import static java.lang.System.out;

public class StackTraceDemo {
    public static void main(String[] args) {
        c();
    }

    static void c() {
        b();
    }

    static void b() {
        a();
    }

    static void a() {
        var currentThread = Thread.currentThread();
        var stackTrace = currentThread.getStackTrace();

        out.printf("Stack trace of thread %s:%n", currentThread.getName());
        List.of(stackTrace).forEach(System.out::println);
    }
}
