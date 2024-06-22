package com.example.basic.lesson15.example.expression;

import static java.lang.System.out;

public class SplitDemo {
    public static void main(String[] args) {
        // 根據逗點切割
        for (var token : "Justin,Monica,Irene".split(",")) {
            out.println(token);
        }
        // 根據 Orz 切割
        for (var token : "JustinOrzMonicaOrzIrene".split("Orz")) {
            out.println(token);
        }
        // 根據 Tab 字元切割
        for (var token : "Justin\tMonica\tIrene".split("\t")) {
            out.println(token);
        }
    }
}
