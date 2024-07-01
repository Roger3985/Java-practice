package com.roger.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    private int id;
    private String categoryName;
    private String categoryAlias;
    private int createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}