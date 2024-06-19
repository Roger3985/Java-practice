package com.example.basic.lesson11.example;

import java.util.concurrent.atomic.AtomicInteger;

class Variable4 {
    // 指定整數初值，建立 AtomicInteger 實例
    static AtomicInteger i = new AtomicInteger(0);
    static int j = 0;

    static void increment() {
        // 遞增並取得整數值
        System.out.printf("thread1 變更了 i: %d%n", i.incrementAndGet());
    }

    static void showChanged() {
        // 取得整數值
        if (i.get() != j) {
            j = i.get();
            System.out.printf("i 變更了：%d%n", i);
        }
    }
}

public class Variable4Test {
    public static void main(String[] args) {
        var thread1 = new Thread(() -> {
            while (true) {
                // 模擬每隔一段時間更新
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Variable4.increment();
            }
        });

        var thread2 = new Thread(() -> {
            while (true) {
                Variable4.showChanged();
            }
        });

        thread1.start();
        thread2.start();
    }
}
