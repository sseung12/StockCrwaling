package com.lss.jsoup;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class rgex {

    @Test
    void regextest() {

        String word ="((123)";

        System.out.println(word.replaceAll("[()]",""));
    }
}
