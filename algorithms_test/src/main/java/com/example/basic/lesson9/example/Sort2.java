package com.example.basic.lesson9.example;

import java.util.*;

record Customer2(String id, String name, int age)
                                   implements Comparable<Customer2> { // 假如物件沒有實作 Comparable ，就會拋出 ClassCastException
    @Override
    public int compareTo(Customer2 other) {
        return this.age - other.age;
    }
}
public class Sort2 {
    public static void main(String[] args) {
        var accounts = Arrays.asList(
                new Customer2("X1234", "Justin", 46),
                new Customer2("X5678", "Monica", 43),
                new Customer2("X2468", "Irene", 13)
        );
        Collections.sort(accounts);
        System.out.println(accounts);
    }
}
