package com.example.basic.lesson10.example;

import java.io.*;

public class Copy {
    public static void main(String[] args) throws IOException {
        IO.dump(
          new FileInputStream(args[0]),
          new FileOutputStream(args[1])
        );
    }
}
