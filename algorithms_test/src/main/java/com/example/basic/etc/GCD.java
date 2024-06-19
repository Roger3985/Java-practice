package com.example.basic.etc;

public class GCD {

    // 使用輾轉相除法計算最大公因數
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // main 方法執行的區域
    public static void main(String[] args) {
        int m = 1000;
        int n = 495;

        int result = gcd(m, n);
        System.out.println("The GCD of " + m + " and " + n + " is " + result);
    }
}
