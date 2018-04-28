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
            // 获取请求内容
            Map<String, Object> objectMap = ArticleContentUtils.getArticle(titlePath);
            // 获取内容中的articleList
            ArticleList articleList = (ArticleList) objectMap.get(Constant.ARTICLE_LIST);
            // 设置关联的文章内容请求指数
            articleList.setContentNumber(index);
            // 设置文章id
            articleList.setArticleId(articleResult.getId());
            // 获取内容中的articleContent
            ArticleContent articleContent = (ArticleContent) objectMap.get(Constant.ARTICLE_CONTENT);
            // 设置文章的请求指数
            articleContent.setNumber(index);
            String preUrl;
            String nextUrl;

            // 如果第一次进来, 则没有上一章
            if (1 == index) {
                preUrl = "/" + articleResult.getId();
            } else {
                preUrl = "/" + articleResult.getId() + "/" + (index - 1);
            }

            // 判断源文章是否有下一章
            boolean nextUrlIsNotEmpty = StringUtils.isNoneEmpty(articleContent.getNextUrl());
            if (nextUrlIsNotEmpty) {
                // 设置下一次请求的源路径
                titlePath = Constant.BI_QU_GE + articleId + "/" + articleContent.getNextUrl();
                nextUrl = "/" + articleResult.getId() + "/" + (index + 1);

            } else {
                nextUrl = "/" + articleResult.getId();
            }
            // 设置上一章url
            articleContent.setPreUrl(preUrl);
            // 设置下一章url
            articleContent.setNextUrl(nextUrl);
            // 设置文章id
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

    @Override
    public List<Article> findByClassifyId(Integer classifyId) {
        return articleRepository.findByClassifyId(classifyId);
    }
}
