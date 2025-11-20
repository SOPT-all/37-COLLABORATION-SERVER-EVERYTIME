package com.everytime.global.exception.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MarketSuccessCode implements SuccessCode {

    GET_MARKET_LIST(HttpStatus.OK.value(), "장터 목록 조회 성공");

    private final int status;
    private final String msg;

    MarketSuccessCode(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
