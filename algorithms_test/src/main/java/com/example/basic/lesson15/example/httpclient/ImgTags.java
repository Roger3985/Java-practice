package com.example.basic.lesson15.example.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Pattern;

public class ImgTags {
    public static void main(String[] args) {
        var reges = Pattern.compile("(?s)<img.+?src=\"(.+?)\".*?>");

        var request = HttpRequest
                .newBuilder()
                .uri(URI.create(args[0]))
                .build();

        HttpClient.newHttpClient()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(resp -> resp.body())
                .thenAccept(html -> {
                    var matcher = reges.matcher(html);
                    while (matcher.find()) {
                        System.out.println(matcher.group());
                    }
                })
                .join(); // 加入主執行緒，等 CompletableFuture 完成再結束
    }
}
