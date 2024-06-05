package com.example.algorithms.binarysearch;

public class LinearSearch {

    /**
     * 線性查找
     * Params: a-待查找的升序陣列（可以不是有序陣列）
     *         target-待查找的目標值
     * Returns:
     *         找到則返回索引
     *         找不到就返回-1
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 1. 最差的執行情況
    // 2. 假設每行語句執行一樣
    /*
        資料元素個數為 n
        int i = 0;       1
        i < arr.length;  n+1
        i ++;            n
        a[i] == target;  n
        return -1;       1

        累計執行次數：3n + 3
     */
}
