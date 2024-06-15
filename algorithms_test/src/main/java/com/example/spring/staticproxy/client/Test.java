package com.example.spring.staticproxy.client;

import com.example.spring.staticproxy.service.OrderService;
import com.example.spring.staticproxy.service.OrderServiceImpl;

public class Test {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.detail();
        orderService.modify();
    }
}
