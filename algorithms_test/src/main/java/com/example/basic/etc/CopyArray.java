package com.example.basic.etc;

import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        int[] scores1 = {1, 2, 3, 4, 5};

        // 使用 System.arraycopy() 複製 scores1 到 scores2
        // int[] scores2 = new int[scores1.length];
        // System.arraycopy(scores1, 0, scores2, 0, scores1.length);

        // 使用 Arrays.copyOf() 方法複製陣列
        int[] scores2 = Arrays.copyOf(scores1, scores1.length);

        for (var score : scores2) {
            System.out.printf("%3d", score);
        }
        System.out.println();

        scores2[0] = 99;
        // 不影響 score1 參考的陣列物件
        for (var score : scores1) {
            System.out.printf("%3d", score);
        }
    }
}
