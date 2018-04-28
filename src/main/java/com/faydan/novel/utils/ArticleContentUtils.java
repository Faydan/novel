package com.faydan.novel.utils;

import com.faydan.novel.common.Constant;
import com.faydan.novel.entity.ArticleContent;
import com.faydan.novel.entity.ArticleList;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ArticleContentUtils {

    /**
     * 获取标题
     */
    private static String getTitle(Document document) {
        return document.getElementsByClass("bookname").select("h1").text();
    }

    /**
     * 获取内容
     */
    private static String getContent(Document document) {
        String content = document.getElementById("content").html();
        return content.replaceAll(";<=\"=\"/js/\"></>", "");
//        return content.replaceAll("&nbsp;", " ")
//                .replaceAll("<br>", "\r\n")
//                .replaceAll("<script>readx();</script>", "")
//                .replaceAll("<script>chaptererror();</script>", "");
    }

    private static String getNextUrl(Document document) {
        String contentUrl = document.getElementsByClass("next").first().attr("href");
        contentUrl = contentUrl.substring(contentUrl.lastIndexOf("/") + 1);
        int i = contentUrl.indexOf(".html");
        if (i != -1) {
            return contentUrl;
        }
        return null;
    }

    public static Map<String, Object> getArticle(String url) {
        Document document =  DocumentUtils.getDocument(url);
        Map<String, Object> map = new HashMap<>();
        ArticleContent articleContent = new ArticleContent();
        articleContent.setNextUrl(getNextUrl(document));
        articleContent.setContent(getContent(document));
        ArticleList articleList = new ArticleList();
        articleList.setTitle(getTitle(document));
        map.put(Constant.ARTICLE_LIST, articleList);
        map.put(Constant.ARTICLE_CONTENT, articleContent);
        return map;
    }
}
