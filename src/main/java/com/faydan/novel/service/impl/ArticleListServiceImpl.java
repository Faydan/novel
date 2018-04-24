package com.faydan.novel.service.impl;

import com.faydan.novel.entity.Article;
import com.faydan.novel.entity.ArticleList;
import com.faydan.novel.repository.ArticleListRepository;
import com.faydan.novel.service.ArticleListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleListServiceImpl implements ArticleListService {

    @Resource
    private ArticleListRepository articleListRepository;

    @Override
    public ArticleList save(ArticleList articleList) {
        return articleListRepository.save(articleList);
    }

    @Override
    public List<ArticleList> findListByArticleId(Long articleId) {
        return articleListRepository.findByArticleId(articleId);
    }
}
