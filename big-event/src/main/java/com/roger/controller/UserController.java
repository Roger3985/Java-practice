package com.roger.controller;

import com.roger.pojo.Result;
import com.roger.pojo.User;
import com.roger.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\${5,16}") String username, @Pattern(regexp = "^\\${5,16}") String password) {

        // 查詢會員
        User u = userService.findByUserName(username);
        if (u == null) {
            // 沒用佔用
            // 註冊
            userService.register(username, password);
            return Result.success();
        } else {
            // 佔用
            return Result.error("會員名已被佔用");
        }
    }
}
