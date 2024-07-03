package com.roger.controller;

import com.roger.pojo.Result;
import com.roger.pojo.User;
import com.roger.service.UserService;
import com.roger.utils.JwtUtil;
import com.roger.utils.MD5Utils;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\w{5,16}$") String username, @Pattern(regexp = "^\\w{5,16}$") String password) {
        // 判斷會員名稱是否存在
        User loginUser = userService.findByUserName(username);

        // 判斷該會員是否存在
        if (loginUser == null) {
            return Result.error("會員名稱錯誤");
        }

        // 判斷密碼是否正確 loginUser 物件中的 password 是密文
        if (MD5Utils.getMD5(password).equals(loginUser.getPassword())) {
            // 登入成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.generateToken(claims);
            return Result.success(token);
        }

        return Result.error("密碼錯誤");
    }
}
