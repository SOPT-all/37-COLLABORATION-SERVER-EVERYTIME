package com.everytime.global.exception.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SearchSuccessCode implements SuccessCode {

    GET_POST_SEARCH_RESULT(HttpStatus.OK.value(), "게시글 검색 결과 조회 완료");

    private final int status;
    private final String msg;

    SearchSuccessCode(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
