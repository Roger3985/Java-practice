package com.roger.servletpractice.lesson2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(
        name = "TimeServlet",
        urlPatterns = "/time",
        loadOnStartup = 1)
public class Time extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Servlet Time</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("</body>");
        out.println(LocalDateTime.now());
        out.println("</html>");
    }
}
