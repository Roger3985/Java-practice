package com.example.basic.lesson15.example;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandlerDemo {
    public static void main(String[] args) throws IOException {
        var logger = Logger.getLogger(HandlerDemo.class.getName());
        logger.setLevel(Level.CONFIG);
        var handler = new FileHandler("%h/config.log");
        handler.setLevel(Level.CONFIG);
        logger.addHandler(handler);
        logger.config("Logger 組態完成");
    }
}
