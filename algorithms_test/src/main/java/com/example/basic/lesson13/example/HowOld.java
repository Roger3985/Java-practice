package com.example.basic.lesson13.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HowOld {
    public static void main(String[] args) throws Exception {
        System.out.print("輸入出生日期(yyyy-mm-dd)：");
        var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        var birthDate = dateFormat.parse(
                new Scanner(System.in).nextLine()
        );
        var currentDate = new Date();
        var life = currentDate.getTime() - birthDate.getTime();
        System.out.println("你今年的歲數為：" + (life / (365 * 24 * 60 * 60 * 1000L)));
    }
}
