package com.faydan.novel.download;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Download {

    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = null;
        BufferedOutputStream buff = null;
        try {
            File destFile = new File("D:\\校园风流邪神.txt");
            outputStream = new FileOutputStream(destFile);
            buff = new BufferedOutputStream(outputStream);
            List<Article> articleList = ArticleUtils.getArticle("26_26119");
            for (Article article : articleList) {
                buff.write(article.getTitle().getBytes());
                buff.write(article.getContent().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert buff != null;
            buff.flush();
            buff.close();
        }

    }

}
