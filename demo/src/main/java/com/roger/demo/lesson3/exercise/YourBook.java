package com.roger.demo.lesson3.exercise;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/yourbook")
public class YourBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("image/jpeg");
        ImageIO.write(
                getImage(request.getParameter("name")),
                "JPG",
                response.getOutputStream()
        );
    }

    public BufferedImage getImage(String name) throws IOException {
        var bufferedImage = ImageIO.read(
                getServletContext().getResourceAsStream("book.jpg"));
        var g = bufferedImage.getGraphics();
        g.setColor(Color.BLACK);
        g.setFont(new Font("標楷體", Font.BOLD, 22));
        g.drawString(name, 15, 45);
        return bufferedImage;
    }
}
