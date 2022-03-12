package com.lss.jsoup.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.thymeleaf.templateparser.reader.ParserLevelCommentTextReader;

import java.io.IOException;

public class wiki {

    public static void main(String[] args) {

        String url ="https://wikibook.co.kr/";
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Elements elements = doc.select("div.card_content");

            for (Element e : elements) {
//                String title = e.select();
//                System.out.println("title = " + title);
//                String nextUrl = e.attr("href");
//                System.out.println("nextUrl = " + nextUrl);
//                Document nextDoc = Jsoup.connect(nextUrl).get();
//                System.out.println("nextDoc = " + nextDoc);
//                String content = nextDoc.select("div.tab-content").html();
//                System.out.println("content = " + content);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
