package com.example.basic.lesson14.example.nio.book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import static java.lang.System.out;

public class BasicFileAttributesDemo {
    public static void main(String[] args) throws IOException {
        var file = Paths.get("/Users/sunzhengchang/Java practice /algorithms_test/src/main/java/com/example/basic/lesson11/example/important");
        BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
        out.printf("creationTime: %s%n", attrs.creationTime());
    }
}
