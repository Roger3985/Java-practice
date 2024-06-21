package com.example.basic.lesson12.example;

public class CustomFunctionalInterfaceExample {
    public static void main(String[] args) {
        CustomFunctionalInterface addition = (a, b) -> a + b;
        CustomFunctionalInterface multiplication = (a, b) -> a * b;

        System.out.println("Addition: " + addition.calculate(5, 3)); // Output: Addition: 8
        System.out.println("Multiplication: " + multiplication.calculate(5, 3)); // Output: Multiplication: 15
    }
}
