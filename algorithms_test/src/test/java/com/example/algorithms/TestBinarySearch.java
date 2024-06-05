package com.example.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.example.algorithms.binarysearch.BinarySearch.binarySearchAlternative;
import static com.example.algorithms.binarysearch.BinarySearch.binarySearchBasic;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinarySearch {

    /**
     * 利用binarySearch二分查找法查找，驗證找到的結果
     */
    @Test
    @DisplayName("binarySearchBasic 找到")
    public void test1() {
        int[] arr = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchBasic(arr, 7));
        assertEquals(1, binarySearchBasic(arr, 13));
        assertEquals(2, binarySearchBasic(arr, 21));
        assertEquals(3, binarySearchBasic(arr, 30));
        assertEquals(4, binarySearchBasic(arr, 38));
        assertEquals(5, binarySearchBasic(arr, 44));
        assertEquals(6, binarySearchBasic(arr, 52));
        assertEquals(7, binarySearchBasic(arr, 53));
    }

    /**
     * 利用binarySearch二分查找法查找，驗證沒找到的結果
     */
    @Test
    @DisplayName("binarySearchBasic 沒找到")
    public void test2() {
        int[] arr = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(-1, binarySearchBasic(arr, 0));
        assertEquals(-1, binarySearchBasic(arr, 15));
        assertEquals(-1, binarySearchBasic(arr, 60));
    }

    /**
     * 測試 (i + j) / 2 的問題
     */
    public static void main(String[] args) {
        int i = 0;
        int j = Integer.MAX_VALUE - 1;

        int m = (i + j) / 2;
        System.out.println(m);

        // 以下會出現複數，是因為當 j + 1 就會超出 Integer 的最大質，導致問題出現。
        /*
         * 同一個二進制數
         * 1011_1111_1111_1111_1111_1111_1111_1110
         * 不把最高位視為符號位，代表 3221225470
         * 把最高位視為符號位，代表 -1073741826
         * 這樣就會導致出現錯誤。
         * 解決辦法為使用右移運算符（無符號表示法） >>> 來表示，一樣是除二取整，但不會超出最到的數值，
         * 還有一個好處，就是可以適用多種語言。
         */
        i = m + 1;
        m = (i + j) / 2;
        System.out.println(m);
    }

    /**
     * 利用binarySearch改動版二分查找法查找，驗證找到的結果
     */
    @Test
    @DisplayName("binarySearchAlternative 找到")
    public void test4() {
        int[] arr = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchAlternative(arr, 7));
        assertEquals(1, binarySearchAlternative(arr, 13));
        assertEquals(2, binarySearchAlternative(arr, 21));
        assertEquals(3, binarySearchAlternative(arr, 30));
        assertEquals(4, binarySearchAlternative(arr, 38));
        assertEquals(5, binarySearchAlternative(arr, 44));
        assertEquals(6, binarySearchAlternative(arr, 52));
        assertEquals(7, binarySearchAlternative(arr, 53));
    }

    /**
     * 利用binarySearch改動版二分查找法查找，驗證沒找到的結果
     */
    @Test
    @DisplayName("binarySearchAlternative 沒找到")
    public void test5() {
        int[] arr = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(-1, binarySearchAlternative(arr, 0));
        assertEquals(-1, binarySearchAlternative(arr, 15));
        assertEquals(-1, binarySearchAlternative(arr, 60));
    }

    @Test
    @DisplayName("binarySearch Java版")
    public void test8() {
        /*
               [2, 5, 8] a
               [2, 0, 0, 0] b
               [2, 4, 0, 0] b
               [2, 4, 5, 8] b
         */

        int[] arr = {2, 5, 8};
        int target = 4;

        int i = Arrays.binarySearch(arr, target);
        System.out.println(i);
        // -2 = - 插入點 - 1
        // -2+1 = - 插入點

        if (i < 0) {
            int insertIndex = Math.abs(i + 1); // 插入點索引
            int[] b = new int[arr.length + 1];
            System.arraycopy(arr, 0, b, 0, insertIndex);
            b[insertIndex] = target;
            System.arraycopy(arr, insertIndex, b, insertIndex + 1, arr.length - insertIndex);
            System.out.println(Arrays.toString(b));
        }
    }


}
