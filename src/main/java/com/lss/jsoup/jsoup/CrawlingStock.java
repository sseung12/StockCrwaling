package com.lss.jsoup.jsoup;

import com.lss.jsoup.domain.Stock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.thymeleaf.templateparser.reader.ParserLevelCommentTextReader;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrawlingStock {

    public Stock Crawling() throws IOException {

        String url = "https://invest.zum.com/domestic/item/035720?query=%EC%B9%B4%EC%B9%B4%EC%98%A4&r=1&qm=g_suggest.finanace";
        Stock stock = null;
        Document doc;
        List<String> result = new ArrayList<>();

        try {
            doc = Jsoup.connect(url).get();

            Element title = doc.selectFirst("div.stock_board");

            String name = title.selectFirst("a").text();
            String price = title.selectFirst("span.price").text();
            String point = title.selectFirst("span.point").text();
            String per = title.selectFirst("span.per").text();


            Element info = doc.selectFirst("ul[data-v-d2826eb4]");
            Elements select = info.select("span.data");


            for (Element element : select) {
                result.add(element.text().replaceAll(",", ""));
            }


            stock = Stock.builder().close_Price(result.get(0))
                    .high_Price(result.get(1))
                    .low_Price(result.get(2))
                    .net_Change(result.get(3))
                    .volume(result.get(4))
                    .date(LocalDate.now())
                    .build();

            System.out.println(stock);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stock;
    }


}
