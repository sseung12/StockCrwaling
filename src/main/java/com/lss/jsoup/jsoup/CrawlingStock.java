package com.lss.jsoup.jsoup;

import com.lss.jsoup.domain.Stock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.thymeleaf.templateparser.reader.ParserLevelCommentTextReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrawlingStock {

    public void Crawling() throws IOException {

        String url ="https://invest.zum.com/domestic/item/035720?query=%EC%B9%B4%EC%B9%B4%EC%98%A4&r=1&qm=g_suggest.finanace";

        Document doc;
            List<String> result = new ArrayList<>();

        try {
            doc = Jsoup.connect(url).get();

            Element info = doc.selectFirst("ul[data-v-d2826eb4]");

            Elements select = info.select("span.data");
            select.stream().map(n ->
                    result.add(n.text().replaceAll(",","")));


            Stock.builder().close_Price(result.get(0))
                    .high_Price(result.get(1))
                    .low_Price(result.get(2))
                    .net_Change(result.get(3))
                    .volume(result.get(4))
                    .build();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        CrawlingStock ct = new CrawlingStock();
        ct.Crawling();
    }
}
