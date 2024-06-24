package com.roger.demo.lesson3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

@WebServlet(name = "HeaderServlet", urlPatterns = "/header")
public class Header extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Show Headers</title>");
        out.print("</head>");
        out.print("<body>");

        Collections.list(request.getHeaderNames()).forEach(name -> {
            out.printf("%s: %s<br>",
                    name, request.getHeader(name));
        });


        out.print("</body>");
        out.print("</html>");
    }
}
