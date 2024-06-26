package com.roger.demo.lesson3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(name = "PostBodyServlet", urlPatterns = "/postbody")
public class PostBody extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println(bodyContent(request.getReader())); // 取得 BufferReader
        out.println("</body>");
        out.println("</html>");
    }

    private String bodyContent(BufferedReader reader) throws IOException {
        return String.join(
                "<br>",
                reader.lines().collect(Collectors.toList())
        );
    }
}
