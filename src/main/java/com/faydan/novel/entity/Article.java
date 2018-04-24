package com.faydan.novel.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String cover;

    @Column(name = "classify_id")
    private Integer classifyId;

    @Column(name = "classify_name")
    private String classifyName;

    private String info;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "last_time")
    private Long lastTime;

}