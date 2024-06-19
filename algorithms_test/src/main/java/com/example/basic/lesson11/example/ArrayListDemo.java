package com.example.basic.lesson11.example;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Race condition 多執行緒的競速情況
 */
public class ArrayListDemo {
    private static final int MAX_SIZE = 10000; // 限制執行緒大小，避免 OutMemory 的狀況出現

    public static void main(String[] args) {
        var list = new CopyOnWriteArrayList<Integer>(); // 提供更好的多執行緒安全 相比 ArrayList 多執行緒情況下不安全
        var thread1 = new Thread(() -> {
            while (true) {
                if (list.size() < MAX_SIZE) {
                    list.add(1);
                }
            }
        });

        var thread2 = new Thread(() -> {
            while (true) {
                if (list.size() < MAX_SIZE) {
                    list.add(2);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}