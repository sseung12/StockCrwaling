package com.lss.jsoup.domain;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class Stock {

    private LocalDate date;

    //종가
    private String open_Price;

    //시가
    private String close_Price;

    //등락률
    private String rate;

    //고가
    private String high_Price;

    //저가
    private String low_Price;

    //거래량
    private String volume;

    //전일대비
    private String net_Change;
}
