package com.lss.jsoup.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

    @GetMapping("/api/hello1")
    public String hello() {
        return "hello";
    }

}
