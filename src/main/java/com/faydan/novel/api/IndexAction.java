package com.faydan.novel.api;

import com.faydan.novel.entity.Article;
import com.faydan.novel.entity.Classify;
import com.faydan.novel.service.ArticleService;
import com.faydan.novel.service.ClassifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexAction {

    @Resource
    private ArticleService articleService;

    @Resource
    private ClassifyService classifyService;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Article> articleList = articleService.findAll();
        List<Classify> classifyList = classifyService.findListByLevel(1);
        model.addAttribute("articleList", articleList);
        model.addAttribute("classifyList", classifyList);
        return "index/index";
    }
}
