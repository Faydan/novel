package com.faydan.novel.repository;

import com.faydan.novel.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findByClassifyId(Integer classifyId);
}
