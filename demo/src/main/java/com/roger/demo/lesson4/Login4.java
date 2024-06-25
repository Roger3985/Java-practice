package com.roger.demo.lesson4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login4")
public class Login4 extends HttpServlet {
    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");

        String page;
        if("caterpillar".equals(name) && "12345678".equals(passwd)) {
            processCookie(request, response);
            page = "user";
        }
        else {
            page = "login.html";
        }
        response.sendRedirect(page);
    }

    private static final int ONE_WEEK = 7 * 24 * 60 * 60;

    private void processCookie(
            HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("user", "caterpillar");
        if("true".equals(request.getParameter("auto"))) {
            cookie.setMaxAge(ONE_WEEK);
        }
        response.addCookie(cookie);
    }
}