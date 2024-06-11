package com.example.basic.lesson4.string;

public class Average {
    public static void main(String[] args) {
        // 檢查命令行參數是否為空
        if (args.length == 0) {
            System.out.println("請提供數字作為命令行參數。");
            return;
        }


        var sum = 0;
        var validArgsCount = 0; // 紀錄有效的參數個數
        for (var arg : args) {
            try {
                long number = Long.parseLong(arg);
                sum += Long.parseLong(arg);
                validArgsCount++;
            } catch (NumberFormatException e) {
                System.out.println("錯誤：'" + arg + "' 不是有效的數字。");
            }
        }

        // 檢查使否有有效的參數
        if (validArgsCount == 0) {
            System.out.println("未找到有效的數字。");
            return;
        }

        System.out.println("平均：" + (float) sum / validArgsCount);
    }
}
