package com.roger.demo.lesson4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@WebServlet("/member")
public class Member extends HttpServlet {
    private final String USERS = "c:/workspace";
    private final String  MEMBER_PATH = "member.view";
    private final String LOGIN_PATH = "index.html";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(
            HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        if (req.getSession().getAttribute("login") == null) {
            resp.sendRedirect(LOGIN_PATH);
            return;
        }

        req.setAttribute("messages", messages(getUsername(req)));
        req.getRequestDispatcher(MEMBER_PATH).forward(req, resp);
    }

    private String getUsername(HttpServletRequest req) {
        return (String) req.getSession().getAttribute("login");
    }

    private Map<Long, String> messages(String username) throws IOException {
        var userhome = Paths.get(USERS, username);
        var messages = new TreeMap<Long, String>(Comparator.reverseOrder());
        try (var txts = Files.newDirectoryStream(userhome, "*.txt")) {
            for (var txt : txts) {
                var millis = txt.getFileName().toString().replace(".txt", "");
                var blabla = Files.readAllLines(txt).stream()
                        .collect(
                                Collectors.joining(System.lineSeparator())
                        );
                messages.put(Long.parseLong(millis), blabla);
            }
        }

        return messages;
    }
}
