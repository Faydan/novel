package com.faydan.novel.repository;

import com.faydan.novel.entity.ArticleList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleListRepository extends CrudRepository<ArticleList, Long> {
    List<ArticleList> findByArticleId(Long articleId);

    ArticleList findByArticleIdAndContentNumber(Long articleId, Integer number);
}
