package com.lss.jsoup.jsoup;

import com.lss.jsoup.domain.Course;
import com.lss.jsoup.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

//@RestController
@RequiredArgsConstructor
public class inflearn {

//    private final CourseService service;

//    @GetMapping("/crawling")
    public void Crawling() throws IOException{

        String url ="https://www.inflearn.com/courses/it-programming/web-dev";

        Document doc;
        try {
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36")
                    .header("scheme", "https")
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("accept-encoding", "gzip, deflate, br")
                    .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
                    .header("cache-control", "no-cache")
                    .header("pragma", "no-cache")
                    .header("upgrade-insecure-requests", "1")
                    .get();
            System.out.println(doc.body().text().trim());
//            Elements elements = doc.select("div.course_card_item");
//
//            for (Element e : elements) {
//                String title = e.select("div.course_title").text().trim();
//                String teacher = e.select("div.instructor").text().trim();
//                String price = e.select("div.price").text().trim();
//                String nextUrl = "http://inflearn.com"+e.select("a.course_card_front").attr("href");
//                Document nextDoc = Jsoup.connect(nextUrl).get();
//                String context = nextDoc.select("p.cd-body__description").text().trim();
//
//                System.out.println(title);
//                Course course = Course.builder().title(title)
//                        .context(context)
//                        .price(price)
//                        .teacher(teacher)
//                        .build();
//                service.save(course);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        inflearn i = new inflearn();
        i.Crawling();
    }
}
