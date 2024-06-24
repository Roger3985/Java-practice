package com.roger.demo.lesson2.exercise;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


@WebServlet(urlPatterns = "/request")
public class Request extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Exercise 2.1</title>");
        out.print("</head>");
        out.print("<body>");
        out.printf("<h1>Now Time: %s</h1>", LocalDateTime.now());
        out.printf("<h1>From: %s</h1>", request.getRemoteAddr());
        out.printf("<h1>Query String: %s</h1>", request.getQueryString());
        out.print("</body>");
        out.print("</html>");


    }
}