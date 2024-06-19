package com.example.basic.lesson9.example;

import java.util.*;

public class Message2 {
    public static void main(String[] args) {
        var messages = new TreeMap<String, String>();
        messages.put("Justin", "Hello ! Justin 的訊息！");
        messages.put("Monica", "給 Monica 的悄悄話！");
        messages.put("Irene", "Irene 的可愛喵喵叫！");
        System.out.println(messages);
    }
}
