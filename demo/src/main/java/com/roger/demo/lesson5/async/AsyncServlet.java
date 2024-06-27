package com.roger.demo.lesson5.async;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.concurrent.CompletableFuture;

@WebServlet(
        urlPatterns = {"/async"},
        asyncSupported = true // 標記 Servlet 支援非同步處理
)
public class AsyncServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        AsyncContext ctx = request.startAsync(); // 開始非同步處理，釋放執行緒

        // 建立非同步處理任務的 CompletableFuture
        asyncResource(ctx).thenAcceptAsync(resource -> {
            try {
                ctx.getResponse().getWriter().println(resource);
                ctx.complete(); // 對瀏覽器完成回應
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });
    }

    private CompletableFuture<String> asyncResource(AsyncContext ctx) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String resource = ctx.getRequest().getParameter("resource");
                Thread.sleep(10000);
                return String.format("%s back finally...XD",
                        resource.toUpperCase());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
