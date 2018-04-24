package com.faydan.novel.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "article_content")
public class ArticleContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    private String content;

    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "pre_url")
    private String preUrl;

    @Column(name = "next_url")
    private String nextUrl;

}