package com.roger.service;

import com.roger.pojo.User;

public interface UserService {

    // 查找會員
    User findByUserName(String username);

    // 註冊
    void register(String username, String password);
}
