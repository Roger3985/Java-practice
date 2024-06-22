package com.example.basic.lesson14.example.nio.book;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import static java.lang.System.out;

public class Roots {
    public static void main(String[] args) {
        var dirs = FileSystems.getDefault().getRootDirectories();
        dirs.forEach(out::println);
    }
}
