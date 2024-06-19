package com.example.basic.etc;

public class ArmstrongNumbers {

    // 方法判斷一個數是否為阿姆斯特丹數
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += (int) Math.pow(digit, 3);
            number /= 10;
        }
        return sum == originalNumber;
    }

    public static void main(String[] args) {
        System.out.println("All 3-digit Armstrong numbers:");
        for (int i = 100; i < 1000; i++) {
            if (isArmstrong(i)) {
                System.out.println(i);
            }
        }
    }
}
