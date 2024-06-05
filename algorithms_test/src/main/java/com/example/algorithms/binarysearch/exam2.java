package com.example.algorithms.binarysearch;

public class exam2 {
    /*
     * 搜索插入位置：
     * 給定一個排序陣列和目標值，在陣列中找到目標值，並返回其索引。
     * 如果目標值不存在於陣列中，返回它將會被按順序插入的位置。
     * 請必須使用時間複雜度O(log n) 的演算法
     */

    /**
     * 第一種 Java 內置解體方法
     */
    public int searchInsert(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) >>> 1;
            long midVal = a[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid; // key found
        }
        return low; // key not found
    }

    /**
     * 第二種解體法：Leftmost
     */
    public int searchInsert2(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 2;
            if (target < a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
