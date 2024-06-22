package com.example.basic.lesson15.example.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Search {
    public static void main(String[] args)
                            throws IOException, InterruptedException {
        var params = Map.of("q", "Java SE 17 技術手冊", "lr", "lang_zh_TW");
        var uri = URI.create(
                "https://www.google.com/search?" +
                        RequestHelper.queryString(params, "UTF-8")
        );

        var request = HttpRequest.newBuilder()
                .header("User-Agent", "Mozilla/5.0")
                .build();

        System.out.println(
                HttpClient
                        .newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString())
                        .body()
        );
    }
}
