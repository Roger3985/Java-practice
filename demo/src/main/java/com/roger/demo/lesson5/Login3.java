package com.roger.demo.lesson5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "Login3",
        urlPatterns = {"/login3"},
        initParams = {
                @WebInitParam(name = "SUCCESS", value = "success.view"),
                @WebInitParam(name = "ERROR", value = "error.view")
        }
)
public class Login3 extends HttpServlet {
    private String SUCCESS_PATH;
    private String ERROR_PATH;

    @Override
    public void init() throws ServletException {
        SUCCESS_PATH = getInitParameter("SUCCESS");
        ERROR_PATH = getInitParameter("ERROR");
    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String path = login(name, password) ? SUCCESS_PATH : ERROR_PATH;
        response.sendRedirect(path);
    }

    private boolean login(String name, String password) {
        return "caterpillar".equals(name) && "123456".equals(password);
    }
}
