package com.example.algorithms.binarysearch;

public class exam1 {
    /*
     * 二分查找:
     * 給定一個 n 個元素有序的（升序）整數型陣列 nums 和一個目標值 target,
     * 寫一個函數搜索 nums 中的 target, 如果目標值存在返回下標, 否則返回 -1
     */

    /**
     * 基礎寫法
     */
    public int search(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;

        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 改動版寫法
     */
    public int search2(int[] a, int target) {
        int i = 0;
        int j = a.length; // 改動1
        while (i < j) {   // 改動2
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;    // 改動3
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 平衡版
     */
    public int search3(int[] a, int target) {
        int i = 0;
        int j = a.length;
        while (i + 1 == j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) { // 左
                j = m;
            } else { // 右, 或 m
                i = m;
            }
        }
        return (a[i] == target) ? i : -1;
    }
}
