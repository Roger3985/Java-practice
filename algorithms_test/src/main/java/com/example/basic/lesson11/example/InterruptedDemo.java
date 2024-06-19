package com.example.basic.lesson11.example;

public class InterruptedDemo {
    public static void main(String[] args) {
        var thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(99999);
                } catch (InterruptedException e) {
                    System.out.println("我醒了XD");
                    throw new RuntimeException(e);
                }
            }
        };
        thread.start();
    }
}
