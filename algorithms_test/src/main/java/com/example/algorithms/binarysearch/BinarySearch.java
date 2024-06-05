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
            // int m = (i + j) / 2;
            int m = (i + j) >>> 1; // 此種寫法比較好，(i + j) / 2 會有問題，請看questions
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

    /**
     * 二分查找改動版
     * Params: a-待查找的升序陣列
     *         target-待查找的目標值
     * Returns:
     *         找到則返回索引
     *         找不到就返回 -1
     */
    public static int binarySearchAlternative(int[] arr, int target) {
        int i = 0, j = arr.length; // 第一處改動
        while (i < j) { // 第二處改動
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m;  // 第三處改動：j 要變成中間索引
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

}
