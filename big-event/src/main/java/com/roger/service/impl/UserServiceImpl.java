package com.roger.service.impl;

import com.roger.mapper.UserMapper;
import com.roger.pojo.User;
import com.roger.service.UserService;
import com.roger.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    // 查找會員
    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    // 註冊
    @Override
    public void register(String username, String password) {
        // 加密處理
        String md5 = MD5Utils.getMD5(password);
        // 添加
        userMapper.add(username, md5);
    }
}
