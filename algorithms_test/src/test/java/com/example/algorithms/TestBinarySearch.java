package com.example.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.algorithms.binarysearch.BinarySearch.binarySearchBasic;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinarySearch {

    @Test
    @DisplayName("binarySearchBasic 找到")
    public void test1() {
        int[] arr = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchBasic(arr, 7));
    }

}
