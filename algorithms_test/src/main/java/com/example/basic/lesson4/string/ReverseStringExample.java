package com.example.basic.lesson4.string;

public class ReverseStringExample {
    public static void main(String[] args) {
        String originalString = "Hello World";

        // Using StringBuilder to reverse the string
        StringBuilder stringBuilder = new StringBuilder(originalString);
        String reversedString = stringBuilder.reverse().toString();  // when not toString the reversedString is object.

        // Print the original and reversed strings
        System.out.println("Original String : " + originalString);
        System.out.println("Reversed String : " + reversedString);
    }
}
