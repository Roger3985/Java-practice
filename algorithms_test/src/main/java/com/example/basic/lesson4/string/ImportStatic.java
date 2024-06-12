package com.example.basic.lesson4.string;

import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class ImportStatic {
    public static void main(String[] args) {
        var console = new Scanner(in);
        out.println("Please enter name :");
        out.printf("%s Hello! %n", console.nextLine());
    }
}
