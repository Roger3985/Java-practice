package com.example.basic.lesson9.example;

import java.util.*;

record Customer(String id, String name, int age) {} // record 中的類別都是 final

public class Sort {
    public static void main(String[] args) {
        var accounts = Arrays.asList(
                new Customer("X1234", "Justin", 46),
                new Customer("X5678", "Monica", 43),
                new Customer("X2468", "Irene", 13)
        );
        System.out.println(accounts);
    }
}
