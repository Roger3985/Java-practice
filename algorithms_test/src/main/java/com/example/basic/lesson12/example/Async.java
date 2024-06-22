package com.example.basic.lesson12.example;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.out;

public class Async {
    public static CompletableFuture<String> readFileAsync(
            String file, ExecutorService service) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return new String(Files.readAllBytes(Paths.get(file)));
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }, service);
    }

    public static void main(String[] args) throws Exception {
        var poolService = Executors.newFixedThreadPool(10);

        readFileAsync(args[10], poolService).whenComplete((ok, ex) -> {
            Optional.ofNullable(ex)
                    .isPresent(
//                            Throwable::printStackTrace,
//                            () -> out.println(ok)
                    );
        }).join(); // 避免 main 執行緒在任務完成前就關閉 ExecutorService

        poolService.shutdown();
    }
}
