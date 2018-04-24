package com.faydan.novel.utils;

import com.faydan.novel.common.Constant;
import com.faydan.novel.entity.Article;
import com.faydan.novel.entity.ArticleList;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

@Slf4j
public class ArticleListUtils {

    public static String getTitlePath(String url) {
        Document document = DocumentUtils.getDocument(url + "/");
        Element element = document.getElementById("list").select("dd").get(12);
        String titlePath = element.select("a").attr("href");
        return Constant.BI_QU_GE + titlePath;
    }

}
