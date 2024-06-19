package com.example.basic.lesson10.example;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Download {
    public static InputStream openStream(String uri) throws Exception {
        // Java 11 新增的 HttpClient API
        return HttpClient
                .newHttpClient()
                .send(
                        HttpRequest.newBuilder(URI.create(uri)).build(),
                        HttpResponse.BodyHandlers.ofInputStream()
                )
                .body();
    }

    public static void main(String[] args) throws Exception {
        var src = openStream(args[0]);
        var dest = new FileOutputStream(args[1]);
        IO.dump(src, dest);
    }
}
