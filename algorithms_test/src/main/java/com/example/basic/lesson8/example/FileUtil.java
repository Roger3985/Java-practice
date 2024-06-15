package com.example.basic.lesson8.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtil {
    public static String readFile(String name) {
        var text = new StringBuilder();
        try {
            var console = new Scanner(new FileInputStream(name));
            while (console.hasNext()) {
                text.append(console.nextLine())
                        .append('\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
