package com.lss.jsoup.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CrawlingStock {

    public void Crawling() throws IOException {

        String url ="https://invest.zum.com/domestic/item/035720?query=%EC%B9%B4%EC%B9%B4%EC%98%A4&r=1&qm=g_suggest.finanace";

        Document doc;

        try {
            doc = Jsoup.connect(url).get();
            Elements trs = doc.select("tr");

            for (Element tr : trs) {
                System.out.println(tr.text());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{

    }
}
