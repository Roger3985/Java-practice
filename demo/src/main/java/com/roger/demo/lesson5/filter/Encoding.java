package com.roger.demo.lesson5.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = { "/*" },
           initParams = { @WebInitParam(name = "ENCODING", value = "UTF-8")})
public class Encoding extends HttpFilter {
    public void doFilter(HttpServletRequest request,
                         HttpServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String encoding = getInitParameter("ENCODING");
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
    }
}
