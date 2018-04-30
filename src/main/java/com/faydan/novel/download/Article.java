package com.faydan.novel.download;

import lombok.Data;

@Data
public class Article {

    private String title;

    private String url;

    private String content;

    public Article() {
    }

    public Article(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public Article(String title, String url, String content) {
        this.title = title;
        this.url = url;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
