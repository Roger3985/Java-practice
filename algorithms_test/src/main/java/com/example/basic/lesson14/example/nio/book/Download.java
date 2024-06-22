package com.example.basic.lesson14.example.nio.book;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Download {
    public static InputStream openStream(String uri) throws Exception {
        return HttpClient
                .newHttpClient()
                .send(
                        HttpRequest.newBuilder(URI.create(uri)).build(),
                        HttpResponse.BodyHandlers.ofInputStream()
                )
                .body();
    }

    public static void main(String[] args) throws Exception {
        Files.copy(
                openStream(args[0]), Paths.get(args[1]), REPLACE_EXISTING
        );
    }
}
