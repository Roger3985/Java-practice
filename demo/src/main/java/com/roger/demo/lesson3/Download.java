package com.roger.demo.lesson3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "Download", urlPatterns = "/download")
public class Download extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passwd = request.getParameter("passwd");
        if ("123456".equals(passwd)) {
            response.setContentType("application/pdf");

            try (InputStream in =
                    getServletContext().getResourceAsStream("/WEB-INF/classes/student.pdf")) {
                OutputStream out = response.getOutputStream();
                out.write(in.readAllBytes());
            }
        }
    }
}
