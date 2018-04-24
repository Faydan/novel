package com.faydan.novel.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "article_list")
public class ArticleList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "content_number")
    private Integer contentNumber;

}