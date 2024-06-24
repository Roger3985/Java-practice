package com.roger.demo.lesson2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "PathServlet",
        urlPatterns = "/servlet/*")
public class Path extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Servlet Path</title>");
        out.print("</head>");
        out.print("<body>");
        out.printf("%s<br>", request.getRequestURI());
        out.printf("%s<br>", request.getContextPath());
        out.printf("%s<br>", request.getServletPath());
        out.print(request.getPathInfo());
        out.print("</body>");
        out.print("</html>");
    }
}
