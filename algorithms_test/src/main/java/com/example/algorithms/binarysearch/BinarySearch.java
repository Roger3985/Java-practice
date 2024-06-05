package com.example.algorithms.binarysearch;

public class BinarySearch {

    /**
     * 二分查找基礎版
     * Params: a-待查找的升序陣列
     *         target-待查找的目標值
     * Returns:
     *         找到則返回索引
     *         找不到就返回 -1
     */
    public static int binarySearchBasic(int[] arr, int target) {
        int i = 0, j = arr.length - 1; // 設置指針和初值
        while (i <= j) { // 範圍內有東西
            int m = (i + j) / 2;
            if (target < arr[m]) { // 目標在左邊
                j = m - 1;
            } else if (arr[m] < target) { // 目標在右邊
                i = m + 1;
            } else {
                return m; // 找到了
            }
        }
        return -1;
    }
}
