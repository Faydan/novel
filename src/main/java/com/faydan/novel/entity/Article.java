package com.faydan.novel.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Article {
    private String id;
    private String title;
    private String content;
    private String url;
    private String nextUrl;
}
