package com.faydan.novel.service.impl;

import com.faydan.novel.common.Constant;
import com.faydan.novel.entity.Article;
import com.faydan.novel.entity.ArticleContent;
import com.faydan.novel.entity.ArticleList;
import com.faydan.novel.repository.ArticleRepository;
import com.faydan.novel.service.ArticleContentService;
import com.faydan.novel.service.ArticleListService;
import com.faydan.novel.service.ArticleService;
import com.faydan.novel.utils.ArticleContentUtils;
import com.faydan.novel.utils.ArticleListUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private ArticleListService articleListService;

    @Resource
    private ArticleContentService articleContentService;

    @Override
    @Transactional
    public void addArticle(Article article, String articleId) {
        // 保存小说
        final Article articleResult = articleRepository.save(article);
        // 得到章节列表的第一个url
        String titlePath = ArticleListUtils.getTitlePath(Constant.BI_QU_GE + articleId);
        Integer index = 1;
        while (true) {
            Map<String, Object> objectMap = ArticleContentUtils.getArticle(titlePath);
            ArticleList articleList = (ArticleList) objectMap.get(Constant.ARTICLE_LIST);
            articleList.setContentNumber(index);
            articleList.setArticleId(articleResult.getId());
            ArticleContent articleContent = (ArticleContent) objectMap.get(Constant.ARTICLE_CONTENT);
            articleContent.setNumber(index);
            if (1 == index) {
                articleContent.setPreUrl("");
            } else {
                articleContent.setPreUrl(String.valueOf(index - 1));
            }

            boolean nextUrlIsNotEmpty = StringUtils.isNoneEmpty(articleContent.getNextUrl());
            if (nextUrlIsNotEmpty) {
                titlePath = Constant.BI_QU_GE + articleId + "/" + articleContent.getNextUrl();
                articleContent.setNextUrl(String.valueOf(index + 1));

            } else {
                articleContent.setNextUrl("");
            }
            articleContent.setArticleId(articleResult.getId());
            articleListService.save(articleList);
            articleContentService.save(articleContent);
            log.info("titlePath-> {}", titlePath);
            // 如果没有下一章, 保存完成之后直接结束
            if (!nextUrlIsNotEmpty) {
                return;
            }

            index ++;
        }
    }

    @Override
    public Iterable<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(Long articleId) {
        return articleRepository.findById(articleId).get();
    }
}
