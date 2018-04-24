package com.faydan.novel.api;

import com.faydan.novel.common.Constant;
import com.faydan.novel.entity.Article;
import com.faydan.novel.entity.ArticleContent;
import com.faydan.novel.entity.ArticleList;
import com.faydan.novel.entity.Classify;
import com.faydan.novel.service.ArticleContentService;
import com.faydan.novel.service.ArticleListService;
import com.faydan.novel.service.ArticleService;
import com.faydan.novel.service.ClassifyService;
import com.faydan.novel.utils.ArticleUtils;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleAction {

    @Resource
    private ArticleService articleService;

    @Resource
    private ArticleListService articleListService;

    @Resource
    private ClassifyService classifyService;

    @Resource
    private ArticleContentService articleContentService;

    @PutMapping("/{classifyId}/{articleId}")
    public void addArticle(@PathVariable Integer classifyId, @PathVariable String articleId) {
        String articleUrl = Constant.BI_QU_GE + articleId;
        Article article = ArticleUtils.getArticle(articleUrl);
        Classify classify = classifyService.findOne(classifyId);
        article.setClassifyId(classify.getId());
        article.setClassifyName(classify.getName());
        article.setCreateTime(System.currentTimeMillis());
        article.setLastTime(System.currentTimeMillis());
        articleService.addArticle(article, articleId);
    }

    @GetMapping("/{articleId}")
    public String getArticleList(@PathVariable Long articleId, Model model) {
        Article article = articleService.findById(articleId);
        List<ArticleList> articleLists = articleListService.findListByArticleId(articleId);
        model.addAttribute("articleLists", articleLists);
        model.addAttribute("title", article.getTitle());
        return "article/articleList";
    }

    @GetMapping("/{articleId}/{number}")
    public String getArticleContent(@PathVariable Long articleId, @PathVariable Integer number, Model model) {

        ArticleContent articleContent = articleContentService.findByArticleIdAndNumber(articleId, number);
        model.addAttribute("articleContent", articleContent.getContent());
        return "article/articleContent";
    }
}
