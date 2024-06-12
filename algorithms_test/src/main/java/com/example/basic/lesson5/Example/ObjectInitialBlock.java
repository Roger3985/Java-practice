package com.example.basic.lesson5.Example;

class Other {
    // 有物件初始化區塊會先執行
    static {
        System.out.println("物件初始區塊");
    }

    Other() {
        System.out.println("Other() 建構式");
    }

    Other(int o) {
        this();
        System.out.println("Other(int o) 建構式");
    }
}

public class ObjectInitialBlock {
    public static void main(String[] args) {
        new Other(1);
    }
}




