package com.roger.demo.lesson2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class Hello extends HttpServlet {
    @Override
    protected void doGet( // 重新定義 doGet()
            HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8"); // 設置回應內容的請求參數

        String name = request.getParameter("name"); // 取得請求參數
        PrintWriter out = response.getWriter(); // 取得回應輸出物件
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Hello</title>");
        out.print("</head>");
        out.print("<body>");
        out.printf("<h1>Hello! %s!%n</h1>", name);
        out.print("</body>");
        out.print("</html>");
    }
}
