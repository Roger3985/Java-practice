package com.example.basic.lesson8.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Average2 {
    public static void main(String[] args) {
        var console = new Scanner(System.in);
        var sum = 0.0;
        var count = 0;
        while (true) {
            try {
                var number = console.nextInt();
                if (number == 0) {
                    break;
                }
                sum += number;
                count++;
            } catch (InputMismatchException e) {
                System.out.printf("略過非整數輸入：%s%n", console.next());
            }
        }
        System.out.printf("平均 %.2f%n", sum / count);
    }
}
