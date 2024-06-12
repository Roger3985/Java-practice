package com.example.basic.lesson4.block;

public class TextBlock {
    public static void main(String[] args) {
        String html =
                """ 
                <!DOCTYPE html>
                <html lang="zh-tw">
                <meta charset="UTF-8">
                <head>
                    <title>%s</title>
                </head>
                <body>
                    <h1>%s</h1>
                </html>
                """;

        String title = "Java Tutorial";
        String content = "<b>Hello, World</b>";

        System.out.println(html.formatted(title, content));
    }
}
