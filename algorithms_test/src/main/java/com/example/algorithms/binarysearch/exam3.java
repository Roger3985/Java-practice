package com.example.algorithms.binarysearch;

public class exam3 {

    /*
     * 在排序陣列中查找元素的第一個和最後一個位置：
     * 給你一個按照非遞減順序排列的整數陣列 nums, 和一個目標值 target。
     * 請你找出給定的目標值在陣列中的開始和結束位置。
     *
     * 如果陣列中不存在目標值 target, 返回 [-1, -1]
     * 你必須設計並實現時間複雜度為 O(log n) 的演算法解決此問題。
     */
    public int[] searchRange(int[]  a, int target) {
        int x = left(a, target);
        if (x == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{x, right(a, target)};
        }
    }

    /**
     * 撰寫 left 的方法
     */
    public int left(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    /**
     * 撰寫 right 的方法
     */
    public int right(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }
}
