package com.roger.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Article {
    private int id;
    private String title;
    private String content;
    private String coverImg;
    private String state;
    private int categoryId;
    private int createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}