package com.example.basic.lesson14.example.nio.book;

import java.nio.file.Paths;

import static java.lang.System.out;

public class PathDemo {
    public static void main(String[] args) {
        var path = Paths.get(
                System.getProperty("user.home"), "Documents", "Downloads");
        out.printf("toString: %s%n", path.toString());
        out.printf("getFileName: %s%n", path.getFileName());
        out.printf("getName(0): %s%n", path.getName(0));
        out.printf("getNameCount(): %s%n", path.getNameCount());
        out.printf("subpath(0, 2): %s%n", path.subpath(0, 2));
        out.printf("getParent(): %s%n", path.getParent());
        out.printf("getRoot(): %s%n", path.getRoot());
    }
}
