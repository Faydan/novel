package com.faydan.novel.service.impl;

import com.faydan.novel.entity.ArticleContent;
import com.faydan.novel.repository.ArticleContentRepository;
import com.faydan.novel.service.ArticleContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleContentServiceImpl implements ArticleContentService {

    @Resource
    private ArticleContentRepository articleContentRepository;
    @Override
    public void save(ArticleContent articleContent) {
        articleContentRepository.save(articleContent);
    }

    @Override
    public ArticleContent findByArticleIdAndNumber(Long articleId, Integer number) {
        return articleContentRepository.findByArticleIdAndNumber(articleId, number);
    }
}
