package com.roger.servletpractice.lesson2.exercise;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class LoginDemo {

    @GetMapping(value = "/loginPage")
    public String loginPage(Model model) {
        return "login";
    }
}