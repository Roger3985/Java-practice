package com.roger.demo.lesson5.listener.welcome;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class OnlineUsers implements HttpSessionListener {
    public static int counter;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        OnlineUsers.counter++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        OnlineUsers.counter--;
    }
}