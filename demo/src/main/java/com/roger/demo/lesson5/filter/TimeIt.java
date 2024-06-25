package com.roger.demo.lesson5.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class TimeIt extends HttpFilter {
    @Override
    protected void doFilter(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        long begin = current();

        chain.doFilter(request, response);

        getServletContext().log(
                String.format("Request process in %d milliseconds.",
                        current() - begin)
        );
    }

    private long current() {
        return System.currentTimeMillis();
    }
}
