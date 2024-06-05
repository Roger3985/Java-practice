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
        // L 次 元素在最左邊 L 次, 元素在最右邊 2*L 次
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

    /*
        1 [2, 3, 4, 5] 5 右側沒找到更差
        int i = 0, j = arr.length - 1; 2
        return -1;                     1
        元素個數        循環次數
        4 - 7          3        floor(log_2(4)) = 2+1
        8 - 15         4        floor(log_2(8)) = 3+1
        16 - 31        5        floor(log_2(16)) = 4+1
        32 - 63        6        floor(log_2(32)) = 5+1
        ...            ...

        循環次數：floor(log_2(n)) + 1

        binarySearchBasic的最糟的循環次數為：floor(log_2(n) + 1) * 5 + 4
        i <= j                 L + 1
        int m = (i + j) >>> 1; L
        target < arr[m]        L
        a[m] < target          L
        i = m + 1              L
     */

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

    /**
     * 二分查找 Leftmost
     * @param arr 待查找的升序陣列
     * @param target 待查找的目標值
     * @return 找到則返回最靠左的索引，找不到就返回-1
     */
    public static int binarySearchLeftmost1(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                // 紀錄後選位置
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    /**
     * 二分查找 Rightmost
     * @param arr 待查找的升序陣列
     * @param target 待查找的目標值
     * @return 找到則返回最靠右的索引，找不到就返回-1
     */
    public static int binarySearchRightmost1(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                // 紀錄後選位置
                candidate = m;
                i = m + 1; // 與Leftmost1的唯一差別
            }
        }
        return candidate;
    }

    /**
     * 二分查找 Leftmost 升級版
     * @param arr 待查找的升序陣列
     * @param target 待查找的目標值
     * @return 返回 >= target 的最靠左的索引位置
     */
    public static int binarySearchLeftmost2(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= arr[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    /**
     * 二分查找 Rightmost 升級版
     * @param arr 待查找的升序陣列
     * @param target 待查找的目標值
     * @return 返回 <= target 的最靠右的索引位置
     */
    public static int binarySearchRightmost2(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                i = m + 1; // 與Leftmost2的唯一差別
            }
        }
        return i - 1;
    }

}
