package com.example.basic.lesson9.example;

import java.util.*;
import static java.util.Comparator.*;

public class Sort4 {
    public static void main(String[] args) {
        var words = Arrays.asList(
                "B", "X", "A", "M", null, "F", "W", "O", null);
        words.sort(nullsFirst(reverseOrder())); // reverseOrder() 反轉 Comparable 物件定義的順序，並利用 nullsFirst 將 null 排在最前頭的規則
        System.out.println(words);
    }
}
