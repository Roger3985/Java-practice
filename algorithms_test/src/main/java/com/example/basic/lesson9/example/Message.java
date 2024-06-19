package com.example.basic.lesson9.example;

import java.util.*;
import static java.lang.System.out;

public class Message {
    public static void main(String[] args) {
        var messages = new HashMap<String, String>(); // HashMap key是無序的
        messages.put("Justin", "Hello ! Justin 的訊息！");
        messages.put("Monica", "給 Monica 的悄悄話！");
        messages.put("Irene", "Irene 的可愛喵喵叫！");

        var console = new Scanner(System.in);
        out.println("取得誰的訊息：");
        String message = messages.get(console.nextLine()); // get() 取得指定鍵取回值
        out.println(message);
        out.println(messages);
    }
}
