package com.faydan.novel.api;

import com.faydan.novel.entity.Article;
import com.faydan.novel.utils.NovelUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@RequestMapping("/article")
public class ArticleApi {

    /**
     * @param args
     */
    public static void main(String[] args)  throws IOException{

        FileOutputStream outputStream = null;
        BufferedOutputStream buff = null;

        File destFile = new File("D:\\大主宰.txt");
        outputStream = new FileOutputStream(destFile);
        buff = new BufferedOutputStream(outputStream);
        String firstUrl = "https://www.1200ksw.com/html/1/1343/597359.html";
        Article article = NovelUtils.getArticle(firstUrl);
        while(article.getNextUrl() != null && article.getContent() != null){
            article = NovelUtils.getArticle(article.getNextUrl());
            buff.write(article.getTitle().getBytes());
            buff.write(article.getContent().getBytes());
        }

        buff.flush();
        buff.close();

    }
}
