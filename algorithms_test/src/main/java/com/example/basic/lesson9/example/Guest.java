package com.example.basic.lesson9.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Guest {
    public static void main(String[] args) {
        var names = new ArrayList();
        collectNameTo(names);
        out.println("訪客名單：");
        printUpperCase(names);
    }

    static void collectNameTo(List names) {
        var console = new Scanner(System.in);
        while(true) {
            out.print("訪客名稱：");
            var name = console.nextLine();
            if (name.equals("quit")) {
                break;
            }
            names.add(name);
        }
    }

    static void printUpperCase(List names) {
        for (var i = 0; i < names.size(); i++) {
            var name = (String) names.get(i); // 使用 get() 依照索引取的物件
            out.println(name.toUpperCase());
        }
    }
}
