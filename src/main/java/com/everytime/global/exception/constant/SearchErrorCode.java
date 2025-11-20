package com.everytime.global.exception.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SearchErrorCode implements ErrorCode {

    CATEGORY_REQUIRED(HttpStatus.BAD_REQUEST.value(), "CATEGORY_REQUIRED", "category 값은 필수입니다."),
    CATEGORY_INVALID(HttpStatus.BAD_REQUEST.value(), "CATEGORY_INVALID", "잘못된 category 값입니다."),

    KEYWORD_REQUIRED(HttpStatus.BAD_REQUEST.value(), "KEYWORD_REQUIRED", "keyword 값은 필수입니다."),
    KEYWORD_TOO_SHORT(HttpStatus.BAD_REQUEST.value(), "KEYWORD_TOO_SHORT", "keyword는 최소 2자 이상이어야 합니다."),

    PAGE_INVALID(HttpStatus.BAD_REQUEST.value(), "PAGE_INVALID", "page 값은 1 이상이어야 합니다."),
    SIZE_INVALID(HttpStatus.BAD_REQUEST.value(), "SIZE_INVALID", "size 값은 1 이상이어야 합니다."),
    PAGE_OUT_OF_RANGE(HttpStatus.BAD_REQUEST.value(), "PAGE_OUT_OF_RANGE", "요청하신 page가 전체 페이지 수를 초과했습니다.");

    private final int httpStatus;
    private final String code;
    private final String msg;

    SearchErrorCode(int httpStatus, String code, String msg) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.msg = msg;
    }
}
