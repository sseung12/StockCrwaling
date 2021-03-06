package com.lss.jsoup.domain;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Builder
public class Stock {

    private String name;

    private LocalDate date;

    //증가,감소값
    private String point;
    //종가
//    private String open_Price;

    //현재 값
    private String price;

    //시가
    private String close_Price;

    //등락률
    private String rate;

    //고가
    private String high_Price;

    //저가
    private String low_Price;

    //거래량(천주)
    private String volume;


    //전일종가
    private String net_Change;
}
