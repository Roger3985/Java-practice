package com.example.basic;

import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        var console = new Scanner(System.in); // 建立 Scanner 實例
        var number = (int) (Math.random() * 10);
        var guess = -1;

        do {
            System.out.println("猜數字（0 ~ 9）：");
            guess = console.nextInt(); // 取得下一個整數
        } while (guess != number);

        System.out.println("猜中了... XD");
    }
}
