package com.example.basic.lesson10.example.charutil;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

public class CharUtilDemo {
    public static void main(String[] args) throws IOException {
        var reader = new FileReader(args[0]);
        var writer = new StringWriter();
        CharUtil.dump(reader, writer);
        System.out.println(writer.toString());
    }
}
