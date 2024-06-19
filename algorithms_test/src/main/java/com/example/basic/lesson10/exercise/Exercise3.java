package com.example.basic.lesson10.exercise;

import java.util.Scanner;
import static com.example.basic.lesson10.exercise.FileUtil.open;

public class Exercise3 {
    public static void main(String[] args) {
        open(args[0], fileInputStream -> {
            var file = new Scanner(fileInputStream);
            while(file.hasNextLine()) {
                System.out.println(file.nextLine());
            }
        });
    }
}