package com.example.basic.lesson10.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {
    public static void dump(InputStream src, OutputStream dest) // 資料來源與目的地
            throws IOException { // 客戶端要處理例外
        try (src; dest) { // 嘗試自動關閉資源
            var data = new byte[1024]; // 存入讀寫的資料
            var length = 0;
            while((length = src.read(data)) != -1) { // 讀取資源
                dest.write(data, 0, length); // 寫出資料
            }
        }
    }
}
