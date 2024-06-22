package com.example.basic.lesson14.example.nio.book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.lang.System.out;

public class Dir {
    public static void main(String[] args) throws IOException {
        try (var directoryStream =
                     Files.newDirectoryStream(Paths.get(args[0]))) {
            var files = new ArrayList<String>();
            for (var path : directoryStream) {
                if (Files.isDirectory(path)) {
                    out.printf("[%s]%n", path.getFileName());
                }
                else {
                    files.add(path.getFileName().toString());
                }
            }
            files.forEach(out::println);
        }
    }
}
