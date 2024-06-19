package com.example.basic.lesson10.example.charutil;

import java.io.*;

public class CharUtil {
    public static void dump(Reader src, Writer dest) throws IOException { // src 資料來源 dest 資料目的地 // throws 客戶端要處理例外
        try (src; dest)  { // 嘗試自動關閉資源
            var data = new char[1024];
            var length = 0;
            while ((length = src.read(data)) != -1) { // 讀取資料
                dest.write(data, 0, length); // 寫出資料
            }
        }
    }
}
