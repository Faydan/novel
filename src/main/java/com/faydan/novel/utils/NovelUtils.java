package com.faydan.novel.utils;

import com.faydan.novel.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class NovelUtils {

    /**
     * 根据utl获取Document对象
     *
     * @param url 小说章节url
     * @return Document对象
     */
    private static Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            log.error("获取Document对象失败-> {}", e);
        }
        return document;
    }

    /**
     * 根据获取的Document对象找到章节标题
     * @param document Document对象
     * @return 标题
     */
    private static String getTitle(Document document){
        return document.getElementsByClass("nr_title").text();
    }

    /**
     * 根据获取的Document对象找到小说内容
     * @param document Document对象
     * @return 内容
     */
    private static String getContent(Document document){
        if(document.getElementsByClass("novelcontent") != null){
            String novelcontent = document.getElementsByClass("novelcontent").html();
            String content = novelcontent.replaceAll("&nbsp;", " ")
                    .replaceAll("<br>", "\r\n")
                    .replaceAll("<p class=\"articlecontent\" id=\"articlecontent\">", "")
                    .replaceAll("</p>", "");
            return content;
        }else{
            return null;
        }
    }

    /**
     * 根据获取的Document对象找到下一章的Url地址
     * @param document Document对象
     * @return 下一章Url
     */
    private static String getNextUrl(Document document){
        Element ul = document.select("div").first();
        String regex = "<a href=\"(.*?)\">下一章<\\/a>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ul.toString());
        Document nextDoc = null;
        if (matcher.find()) {
            nextDoc = Jsoup.parse(matcher.group());
            Element href = nextDoc.select("a").first();
            return "https://www.1200ksw.com/html/1/1343/" + href.attr("href");
        }else{
            return null;
        }

    }

    /**
     * 根据url获取id
     * @param url 小说章节url
     * @return id
     */
    private static String getId(String url){
        String urlSplit[] = url.split("/");
        return (urlSplit[urlSplit.length - 1]).split("\\.")[0];
    }

    /**
     * 根据小说的Url获取一个Article对象
     * @param url 小说章节url
     * @return Article
     */
    public static Article getArticle(String url){
        Article article = new Article();
        article.setUrl(url);
        Document document = getDocument(url);
        article.setId(getId(url));
        article.setTitle(getTitle(document) + "\r\n");
        article.setNextUrl(getNextUrl(document));
        article.setContent(getContent(document) + "\r\n");
        return article;
    }

}
