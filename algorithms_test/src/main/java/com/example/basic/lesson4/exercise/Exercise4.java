package com.example.basic.lesson4.exercise;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        int[] number = {1, 10, 31, 33, 37, 48, 60, 70, 80};

        // 建立一個新陣列 tmp，長度比 number 長度多 1
        var tmp = new int[number.length + 1];

        // 將 number 陣列的值複製到 tmp 陣列中，從 tmp 的索引 1 開始
        for(var i = 1; i < tmp.length; i++) {
            tmp[i] = number[i - 1];
        }

        // 提示使用者輸入要搜尋的數字
        System.out.print("想搜尋？");
        // 讀取使用者輸入的數字，並將其存入 tmp 陣列的第一個位置
        tmp[0] = new Scanner(System.in).nextInt();

        // 設定 i 為 number 陣列的長度，即最後一個元素的索引
        var i = number.length;

        // 從 tmp 陣列中的最後一個元素開始向前搜尋，直到找到與 tmp[0] 相等的值
        while(tmp[i] != tmp[0]) {
            i--;
        }

        // 輸出找到的數字在 number 陣列中的索引位置
        // 因為 tmp 陣列比 number 陣列多一個元素，實際索引位置是 i - 1
        System.out.println(i - 1);
    }
}
