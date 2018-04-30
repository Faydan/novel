package com.faydan.novel.download;

import com.faydan.novel.common.Constant;
import com.faydan.novel.utils.DocumentUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ArticleUtils {

    public static List<Article> getArticle(String source) {
        // 获取章节列表的Document对象
        Document document = DocumentUtils.getDocument(Constant.BI_QU_GE_DOWNLOAD + "/" + source + "/");
        // 获取链接 url 和 标题的对象
        Elements select = document.getElementById("list").select("dd").select("a");
        List<Article> articleList = new ArrayList<>();
        // 把所有的标题和url存入集合
        select.forEach(element -> {
            Article article = new Article(element.text(), Constant.BI_QU_GE_DOWNLOAD + element.attr("href"));
            articleList.add(article);
        });

        List<Article> articleList2 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            articleList.remove(0);
        }
        articleList2.add(articleList.get(0));

        articleList2.forEach(article -> {
            article.setContent(getContent(article.getUrl()));
            System.out.println(article);
        });
        return articleList2;
    }

    private static String getContent(String url) {
        Document document = DocumentUtils.getDocument(url);
        String content = document.getElementById("content").html();

        content = content.replaceAll("\\\\", "")
                .replaceAll("ｗｗw、Ｑb5、Com", "")
                .replaceAll("<br>", "")
                .replace("<script>readx();</script>", "\r\n")
                .replace("<script>chaptererror();</script>", "\r\n");

        return content;
    }

}
