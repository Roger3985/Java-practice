package com.example.basic.lesson11.example.executor;

import java.util.concurrent.Executors;

import static java.lang.System.out;

public class FutureCallableDemo2 {
    static long fibonacci(long n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) throws Exception {
        var service = Executors.newCachedThreadPool();

        out.println("老闆，我要第 30 個費式數，待會來拿...");

        var the30thFibFuture = service.submit(() -> fibonacci(30));
        while (!the30thFibFuture.isDone()) {
            out.println("忙別的事去...");
        }

        out.printf("第 30 個費式數：%d%n", the30thFibFuture.get());

    }
}
