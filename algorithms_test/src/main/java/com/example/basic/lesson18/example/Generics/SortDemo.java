package com.example.basic.lesson18.example.Generics;

public class SortDemo {
    public static void main(String[] args) {
        String[] strs = {"3", "2", "5", "1"};
        for(var s : Sort.sorted(strs)) {
            System.out.println(s);
        }
    }
}