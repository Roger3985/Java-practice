package com.example.basic.lesson13.example;

import java.util.Date;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

public class DateDemo {
    public static void main(String[] args) {
        var date1 = new Date(currentTimeMillis());
        var date2 = new Date();

        out.println(date1.getTime());
        out.println(date2.getTime());
    }
}
