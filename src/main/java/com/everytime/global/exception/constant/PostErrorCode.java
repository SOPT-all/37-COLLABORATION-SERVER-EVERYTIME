package com.everytime.global.exception.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum PostErrorCode implements ErrorCode {
    POST_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "POST_NOT_FOUND", "조회된 게시물이 없습니다.");

    private final int httpStatus;
    private final String code;
    private final String msg;

    PostErrorCode(int httpStatus, String code, String msg) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.msg = msg;
    }
}
