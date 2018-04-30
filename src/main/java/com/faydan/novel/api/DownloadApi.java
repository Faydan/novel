package com.faydan.novel.api;

import com.faydan.novel.download.Article;
import com.faydan.novel.download.ArticleUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/download")
public class DownloadApi {

    @GetMapping("/{source}")
    public void download(@PathVariable String source) {
        FileOutputStream outputStream = null;
        BufferedOutputStream buff = null;
        try {
            File destFile = new File("/home/校园风流邪神.txt");
            outputStream = new FileOutputStream(destFile);
            buff = new BufferedOutputStream(outputStream);
            List<Article> articleList = ArticleUtils.getArticle(source);
            for (Article article : articleList) {
                buff.write(article.getTitle().getBytes());
                buff.write(article.getContent().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert buff != null;
            try {
                buff.flush();
                buff.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
