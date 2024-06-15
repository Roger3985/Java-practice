package com.example.basic.lesson8.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtil {
    public static String readFile(String name) {
        var text = new StringBuilder();
        Scanner console = null;
        try {
            console = new Scanner(new FileInputStream(name));
            while (console.hasNext()) {
                text.append(console.nextLine())
                        .append('\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (console != null) {
                console.close(); // 將 IO 流關閉
            }
        }
        return text.toString();
    }
}
