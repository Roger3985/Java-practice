package com.example.basic.lesson7.example;

public class Main {
    public static void main(String[] args) {
        // 使用匿名內部類繼承類別
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous inner class extending Thread");
            }
        };

        // 創建新執行緒並運行
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
