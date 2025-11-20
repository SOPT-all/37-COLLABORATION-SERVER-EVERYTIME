package com.everytime.global.exception.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum PostSuccessCode implements SuccessCode {
    GET_ALL_POSTS_BY_CATEGORY(HttpStatus.OK.value(), "카테고리 별 상위 4개 게시글 조회 완료"),
    GET_REALTIME_POST(HttpStatus.OK.value(), "실시간 인기 게시글 조회 완료"),
    GET_HOT_POSTS(HttpStatus.OK.value(), "핫 게시물 조회 완료");

    private final int status;
    private final String msg;

    PostSuccessCode(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
