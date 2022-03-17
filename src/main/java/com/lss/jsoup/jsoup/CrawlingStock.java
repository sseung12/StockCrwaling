package com.lss.jsoup.jsoup;

import com.lss.jsoup.domain.Stock;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Slf4j
public class CrawlingStock {

    public String getStockCode(String name) {
        String code="";

        String url = "https://search.naver.com/search.naver?query="+name;
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            String text = doc.selectFirst("em.t_nm").text();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return code;
    }



    public Stock Crawling(String code) throws IOException {

        if (code == null) {
            return null;
        }
        String url = "https://invest.zum.com/domestic/item/035720?query="+code;

        Stock stock = null;
        Document doc;
        List<String> result = new ArrayList<>();

        try {
            doc = Jsoup.connect(url).get();

            Element title = doc.selectFirst("div.stock_board");

            // board에 있는 데이터
            Map<String, String> board = board(title);

            // sidebar 데이터
            Element info = doc.selectFirst("ul[data-v-d2826eb4]");
            Elements select = info.select("span.data");

            for (Element element : select) {
                result.add(subSpecialWord(element.text()));
            }

            stock = Stock.builder().close_Price(result.get(0))
                    .high_Price(result.get(1))
                    .low_Price(result.get(2))
                    .net_Change(result.get(3))
                    .volume(result.get(4))
                    .name(board.get("name"))
                    .rate(board.get("rate"))
                    .price(board.get("price"))
                    .point(board.get("point"))
                    .date(LocalDate.now())
                    .build();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stock;
    }

    public Map<String, String> board(Element title) {
        Map<String,String> result = new HashMap<>();
        result.put("name",subSpecialWord(title.selectFirst("a").text()));
        result.put("price",subSpecialWord(title.selectFirst("span.price").text()));
        result.put("point",subSpecialWord(title.selectFirst("span.point").text()));
        result.put("rate",subSpecialWord(title.selectFirst("span.per").text()));
        return result;
    }

    public String subSpecialWord(String str) {
        return str.replaceAll("[(),]","");
    }
    public static void main(String[] args) throws IOException {
        CrawlingStock c = new CrawlingStock();
        String code = c.getStockCode("카카오");
        Stock crawling = c.Crawling(code);
        System.out.println(crawling);
    }

}
