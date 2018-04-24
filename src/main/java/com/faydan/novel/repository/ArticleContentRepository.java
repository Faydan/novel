package com.faydan.novel.repository;

import com.faydan.novel.entity.ArticleContent;
import org.springframework.data.repository.CrudRepository;

public interface ArticleContentRepository extends CrudRepository<ArticleContent, Long> {
    ArticleContent findByArticleIdAndNumber(Long articleId, Integer number);
}
