package com.example.basic.lesson15.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerDemo {
    public static void main(String[] args) {
        var logger = Logger.getLogger(LoggerDemo.class.getName());
        logger.log(Level.WARNING, "WARNING 訊息");
        logger.log(Level.INFO, "INFO 訊息");
        logger.log(Level.CONFIG, "CONFIG 訊息");
        logger.log(Level.FINE, "FINE 訊息");
    }
}
