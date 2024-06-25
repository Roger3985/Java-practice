package com.roger.demo.lesson5.listener.welcome;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {
    private Map<String, String> users = new HashMap<String, String>() {{
        put("caterpillar", "123456");
        put("momor", "98765");
        put("hamimi", "13579");
    }};

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");

        String page = "form.html";
        if(users.containsKey(name) && users.get(name).equals(passwd)) {
            request.getSession().setAttribute("user", name);
            page = "welcome.view";
        }
        response.sendRedirect(page);
    }
}
