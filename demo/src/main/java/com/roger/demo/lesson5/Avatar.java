package com.roger.demo.lesson5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/avatar"},
        initParams = {
            @WebInitParam(name = "AVATAR_DIR", value = "/avatar")
        }
)
public class Avatar extends HttpServlet {
    private String AVATAR_DIR;

    @Override
    public void init() throws ServletException {
        AVATAR_DIR = getInitParameter("AVATAR_DIR");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");

        getServletContext().getResourcePaths(AVATAR_DIR)
                .forEach(avatar -> {
                    out.printf("<img src='%s'>%n", avatar.replaceFirst("/", ""));
                });

        out.println("</body>");
        out.println("</html>");
    }
}
