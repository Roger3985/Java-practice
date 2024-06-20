package com.example.basic.lesson12.example;

import java.util.Arrays;

public class StringOrderDemo {
    public static void main(String[] args) {
        String[] names = {"Justin", "caterpiller", "Bush"};
        Arrays.sort(names, StringOrder::byLength);
        System.out.println(Arrays.toString(names));
    }
}
