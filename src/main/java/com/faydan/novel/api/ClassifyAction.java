package com.faydan.novel.api;

import com.faydan.novel.entity.Article;
import com.faydan.novel.entity.Classify;
import com.faydan.novel.service.ArticleService;
import com.faydan.novel.service.ClassifyService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassifyAction created with IntelliJ IDEA.
 * User:  faydan
 * Email: fei321457749@126.com
 * Date:  2018-04-25
 * Time:  15:43
 * <p>
 * Describe:
 */
@Controller
@RequestMapping("/list")
public class ClassifyAction {

    @Resource
    private ArticleService articleService;

    @Resource
    private ClassifyService classifyService;

    /**
     * 根据分类返回文章列表
     */
    @GetMapping("/{classifyId}")
    public String articleList(@PathVariable Integer classifyId, Model model) {
        List<Article> articleList = articleService.findByClassifyId(classifyId);
        List<Classify> classifyList = classifyService.findListByLevel(1);
        model.addAttribute("classifyId", classifyId);
        model.addAttribute("articleList", articleList);
        model.addAttribute("classifyList", classifyList);
        return "article/list";
    }

    @PostMapping("/articleList")
    @ResponseBody
    public JSONObject articleList(@RequestParam(required = false, defaultValue = "0") Integer classifyId) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Article> articleList = articleService.findByClassifyId(classifyId);
            List<Classify> classifyList = classifyService.findListByLevel(1);
            jsonObject.put("articleList", articleList);
            jsonObject.put("classifyList", classifyList);
            jsonObject.put("classifyId", classifyId);
            // 如果是0  则到首页
            if (0 == classifyId) {
                jsonObject.put("result", 1);
                jsonObject.put("classifyId", 0);
                jsonObject.put("msg", "获取成功");
                return jsonObject;
            }
        } catch (Exception e) {
            jsonObject.put("result", 0);
            jsonObject.put("msg", "获取失败");
        }
        return jsonObject;
    }
}
