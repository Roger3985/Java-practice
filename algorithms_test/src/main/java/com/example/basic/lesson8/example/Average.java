package com.example.basic.lesson8.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        try {
            var console = new Scanner(System.in);
            var sum = 0.0;
            var count = 0;
            while (true) {
                var number = console.nextInt();
                if (number == 0) {
                    break;
                }
                sum += number;
                count++;
            }
            System.out.printf("平均 %.2f%n", sum / count);
        } catch (InputMismatchException e) {
            System.out.println("必須輸入整數");
        }
    }
}
