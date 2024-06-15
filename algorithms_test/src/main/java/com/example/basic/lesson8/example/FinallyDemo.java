package com.example.basic.lesson8.example;

public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println(test(true));
    }

    static int test(boolean flag) {
        try {
            if (flag) {
                return 1;
            }
        } finally {
            System.out.println("finally..."); // finally 區塊的一定會執行
        }
        return 0;
    }
}
