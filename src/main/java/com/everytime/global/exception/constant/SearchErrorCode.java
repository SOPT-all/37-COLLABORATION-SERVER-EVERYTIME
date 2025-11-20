package com.everytime.global.exception.constant;

import lombok.Getter;

@Getter
public enum SearchErrorCode implements ErrorCode {

    CATEGORY_REQUIRED(400, "CATEGORY_REQUIRED", "category 값은 필수입니다."),
    CATEGORY_INVALID(400, "CATEGORY_INVALID", "잘못된 category 값입니다."),

    KEYWORD_REQUIRED(400, "KEYWORD_REQUIRED", "keyword 값은 필수입니다."),
    KEYWORD_TOO_SHORT(400, "KEYWORD_TOO_SHORT", "keyword는 최소 2자 이상이어야 합니다."),

    PAGE_INVALID(400, "PAGE_INVALID", "page 값은 1 이상이어야 합니다."),
    SIZE_INVALID(400, "SIZE_INVALID", "size 값은 1 이상이어야 합니다."),
    PAGE_OUT_OF_RANGE(400, "PAGE_OUT_OF_RANGE", "요청하신 page가 전체 페이지 수를 초과했습니다.");

    private final int httpStatus;
    private final String code;
    private final String msg;

    SearchErrorCode(int httpStatus, String code, String msg) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.msg = msg;
    }
}
