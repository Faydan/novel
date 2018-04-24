package com.faydan.novel.service;

import com.faydan.novel.entity.Article;

public interface ArticleService {
    void addArticle(Article article, String articleId);

    Iterable<Article> findAll();

    Article findById(Long articleId);
}
