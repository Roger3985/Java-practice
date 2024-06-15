package com.example.basic.lesson8.example;

import java.io.Closeable;
import java.io.IOException;

public class AutoClosableDemo {
    public static void main(String[] args) {
        try (var res = new Resource()) {
            res.doSome();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Resource implements Closeable {
    void doSome() {
        System.out.println("做一些事");
    }

    @Override
    public void close() throws IOException {
        System.out.println("資源被關閉");
    }
}
