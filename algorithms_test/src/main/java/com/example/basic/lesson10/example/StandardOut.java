package com.example.basic.lesson10.example;

import java.io.*;

public class StandardOut {
    public static void main(String[] args) throws IOException {
        try (var file = new PrintStream(new FileOutputStream(args[0]))) {
            System.setOut(file);
            System.out.println("HelloWorld");
        }
    }
}
