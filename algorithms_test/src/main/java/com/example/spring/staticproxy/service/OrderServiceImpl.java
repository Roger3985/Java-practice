package com.example.spring.staticproxy.service;

public class OrderServiceImpl implements OrderService {

    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        // 模擬生成訂單的耗時
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("訂單已生成.");
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    @Override
    public void modify() {
        // 模擬修改訂單的耗時
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("訂單已修改.");
    }

    @Override
    public void detail() {
        // 模擬查詢訂單的耗時
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("查看訂單詳情.");
    }
}
