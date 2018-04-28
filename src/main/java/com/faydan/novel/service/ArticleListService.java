package com.faydan.novel.service;

import com.faydan.novel.entity.ArticleList;

import java.util.List;

public interface ArticleListService {
    ArticleList save(ArticleList articleList);

    List<ArticleList> findListByArticleId(Long articleId);

    ArticleList findByArticleIdAndContentNumber(Long articleId, Integer number);
}
