package com.faydan.novel.utils;

import com.faydan.novel.common.Constant;
import com.faydan.novel.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

@Slf4j
public class ArticleUtils {

    /**
     * 获取标题
     */
    private static String getTitle(Document document) {
        Element info = document.getElementById("info");
        return info.select("h1").text();
    }

    /**
     * 获取作者
     */
    private static String getAuthor(Document document) {
        String author = document.getElementById("info").selectFirst("p").text();
        return author.substring(author.indexOf("：") + 1);
    }

    /**
     * 获取封面路径
     *
     */
    private static String getCover(Document document) {
        String imageUrl = Constant.BI_QU_GE + document.getElementById("fmimg").select("img").attr("src");
        return OssUploadUtils.uploadImage(imageUrl);
    }

    /**
     * 获取简介信息
     */
    private static String getInfo(Document document) {
        return document.getElementById("intro").html();
    }

    /**
     * 根据小说的Url获取一个Article对象
     * @param url 小说章节url
     * @return Article
     */
    public static Article getArticle(String url){
        Article article = new Article();
        Document document = DocumentUtils.getDocument(url + "/");
        article.setTitle(getTitle(document));
        article.setAuthor(getAuthor(document));
        article.setCover(getCover(document));
        article.setInfo(getInfo(document));
        return article;
    }
}
