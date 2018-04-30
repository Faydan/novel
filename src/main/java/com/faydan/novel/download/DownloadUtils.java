package com.faydan.novel.download;

import com.faydan.novel.utils.DocumentUtils;
import org.jsoup.nodes.Document;

public class DownloadUtils {

    private static Document document;

    /**
     * 获取标题
     */
    private static String getTitle() {
        return document.getElementsByClass("bookname").select("h1").text();
    }

    /**
     * 获取内容
     */
    private static String getContent() {
        String content = document.getElementById("content").html();
        return content.replaceAll("<script>readx();</script>", "\r\n")
                .replaceAll("&nbsp;", " ")
                .replaceAll("<br>", "\r\n")
                .replaceAll("<script>chaptererror();</script>", "\r\n");
    }

    private static String getNextUrl() {
        String contentUrl = document.getElementsByClass("next").first().attr("href");
        contentUrl = contentUrl.substring(contentUrl.lastIndexOf("/") + 1);
        int i = contentUrl.indexOf(".html");
        if (i != -1) {
            return contentUrl;
        }
        return null;
    }

}
