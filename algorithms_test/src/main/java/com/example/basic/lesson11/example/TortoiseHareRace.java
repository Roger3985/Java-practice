package com.example.basic.lesson11.example;

import static java.lang.System.out;

public class TortoiseHareRace {
    public static void main(String[] args) {
        boolean[] flags = {true, false};
        var totalStep = 10;
        var tortoiseStep = 0;
        var hareStep = 0;
        out.println("龜兔賽跑開始...");
        while (tortoiseStep < totalStep && hareStep < totalStep) {
            tortoiseStep++; // 烏龜走一步
            out.printf("烏龜跑了 %d步...%n", tortoiseStep);
            var isHareSleep = flags[((int) (Math.random() * 10)) % 2]; // 隨機睡覺
            if (isHareSleep) {
                out.println("兔子睡著了zzz");
            } else {
                hareStep += 2;
                out.printf("兔子跑了 %d 步...%n", hareStep);
            }
        }
    }
}
