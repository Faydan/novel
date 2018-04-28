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
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
public class ArticleAction {

    @Resource
    private ArticleService articleService;

    @Resource
    private ArticleListService articleListService;

    @Resource
    private ClassifyService classifyService;

    @Resource
    private ArticleContentService articleContentService;


    /**
     * 获取所有小说
     * TODO 后期改成获取推荐小说
     */
    @GetMapping("/")
    public String index(Model model) {
        Iterable<Article> articleList = articleService.findAll();
        List<Classify> classifyList = classifyService.findListByLevel(1);
        model.addAttribute("articleList", articleList);
        model.addAttribute("classifyList", classifyList);
        return "index/index";
    }

    @GetMapping("/uploadArticle")
    public String gotoUploadArticle(Model model) {
        model.addAttribute("classifyList", classifyService.findListByLevel(1));
        return "article/uploadArticle";
    }

    /**
     * 添加小说
     *
     * @param classifyId 分类id
     * @param articleId 小说id
     */
    @PostMapping("/{classifyId}/{articleId}")
    @ResponseBody
    public boolean addArticle(@PathVariable Integer classifyId, @PathVariable String articleId) {
        try {
            String articleUrl = Constant.BI_QU_GE + articleId;
            Article article = ArticleUtils.getArticle(articleUrl);
            Classify classify = classifyService.findOne(classifyId);
            article.setClassifyId(classify.getId());
            article.setClassifyName(classify.getName());
            article.setCreateTime(System.currentTimeMillis());
            article.setLastTime(System.currentTimeMillis());
            articleService.addArticle(article, articleId);
            return true;
        } catch (Exception e) {
            log.error("上传文章错误-> {}", e);
            return false;
        }

    }

    /**
     * 获取小说章节
     * @param articleId 小说id
     */
    @GetMapping("/{articleId}")
    public String getArticleList(@PathVariable Long articleId, Model model) {
        Article article = articleService.findById(articleId);
        List<ArticleList> articleLists = articleListService.findListByArticleId(articleId);
        model.addAttribute("articleLists", articleLists);
        model.addAttribute("title", article.getTitle());
        return "article/articleList";
    }

    /**
     * 获取章节内容
     * @param articleId 小说id
     * @param number 章节内容编号
     */
    @GetMapping("/{articleId}/{number}")
    public String getArticleContent(@PathVariable Long articleId, @PathVariable Integer number, Model model) {
        ArticleList articleList = articleListService.findByArticleIdAndContentNumber(articleId, number);
        ArticleContent articleContent = articleContentService.findByArticleIdAndNumber(articleId, number);
        model.addAttribute("articleContent", articleContent);
        model.addAttribute("title", articleList.getTitle());
        return "article/articleContent";
    }
}
