package com.example.basic.lesson17.example;

import static java.lang.System.out;

public class InfoAbout {
    public static void main(String[] args) {
        try {
            Class clz = Class.forName(args[0]);
            out.printf("類別名稱：%s%n", clz.getName());
        } catch (ArrayIndexOutOfBoundsException e) {
            out.println("沒有指定類別名稱");
        } catch (ClassNotFoundException e) {
            out.printf("找不到指定的類別 %s%n", args[0]);
        }
    }
}
