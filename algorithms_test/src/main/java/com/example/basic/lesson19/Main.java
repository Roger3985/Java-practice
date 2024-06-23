package com.example.basic.lesson19;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0 && "test".equals(args[0])) {
            System.out.println("嘗試");
        } else {
            System.out.println("應用程式正常流程");
        }
    }
}
