package com.example.basic.lesson9.example;

import java.util.*;
import static java.lang.System.out;

public class MapKeyValue {
    public static void main(String[] args) {
        var map = new HashMap<String, String>();
        map.put("one", "一");
        map.put("two", "二");
        map.put("three", "三");

        out.println("顯示鍵");
        // keySet() 傳回 Set
        map.keySet().forEach(key -> out.println(key));

        out.println("顯示值");
        // values() 傳回 Collection
        map.values().forEach(key -> out.println(key));
    }
}
