package com.roger.servletpractice.lesson3;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SomeServlet", urlPatterns = "/some")
public class Some extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("Some do one...");
        RequestDispatcher dispatcher = request.getRequestDispatcher("other");
        dispatcher.include(request, response);
        out.println("Some do two...");
    }
}
