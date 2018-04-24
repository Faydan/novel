package com.faydan.novel.service;

import com.faydan.novel.entity.ArticleContent;

import java.util.List;

public interface ArticleContentService {
    void save(ArticleContent articleContent);

    ArticleContent findByArticleIdAndNumber(Long articleId, Integer number);
}
