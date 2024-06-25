package com.roger.demo.lesson5.listener.welcome;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/welcome.view")
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>歡迎</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>目前線上人數 %d 人</h1>", OnlineUsers.counter);

        Optional.ofNullable(request.getSession(false))
                .ifPresent(session -> {
                    String user = (String) session.getAttribute("user");
                    out.printf("<h1>歡迎：%s </h1>", user);
                    out.println("<a href='logout'>登出</a>");
                });

        out.println("</body>");
        out.println("</html>");
    }
}