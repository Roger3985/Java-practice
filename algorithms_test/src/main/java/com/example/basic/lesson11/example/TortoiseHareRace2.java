package com.example.basic.lesson11.example;

public class TortoiseHareRace2 {
    public static void main(String[] args) {
        var tortoise = new Tortoise(10);
        var hare = new Hare(10);
        var tortoiseThread = new Thread(tortoise);
        var hareThread = new Thread(hare);
        // 啟動時，使用 method of the start()
        tortoiseThread.start();
        hareThread.start();
    }
}
