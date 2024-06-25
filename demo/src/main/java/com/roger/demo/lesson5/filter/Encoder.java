package com.roger.demo.lesson5.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class Encoder extends HttpFilter {
    public void doFilter(HttpServletRequest request,
                         HttpServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new EncoderWrapper(request), response); // 用 EncoderWrapper 包裹原請求物件
    }
}
