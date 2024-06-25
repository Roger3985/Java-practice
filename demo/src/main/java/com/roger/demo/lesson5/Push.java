package com.roger.demo.lesson5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/push")
public class Push extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
        Optional.ofNullable(request.newPushBuilder())
                .ifPresent(pushBuilder -> {
                    pushBuilder.path("avatar/caterpillar.jpg")
                               .addHeader("Content-Type", "image/jpeg")
                               .push();
                });

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<img src='avatar/caterpillar.jpg'>");
        out.println("</head>");
        out.println("<body>");
    }
}
