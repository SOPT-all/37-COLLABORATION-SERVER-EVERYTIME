package com.everytime.global.exception.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ReviewSuccessCode implements SuccessCode {

    GET_RECENT_REVIEWS(HttpStatus.OK.value(), "최근 강의평 조회 성공");

    private final int status;
    private final String msg;

    ReviewSuccessCode(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
