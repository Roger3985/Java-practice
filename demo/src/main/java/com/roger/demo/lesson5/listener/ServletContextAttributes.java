package com.roger.demo.lesson5.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener // 使用 @WebListener 標註 （代表此為 Listener）
public class ServletContextAttributes implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String avatar = context.getInitParameter("AVATAR");
        context.setAttribute("avatar", avatar);
    }
}
