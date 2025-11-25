package com.everytime.domain.post.domain.enums;

import lombok.Getter;

@Getter
public enum SearchCategory {
    ALL("전체"),
    FREE("자유게시판"),
    SECRET("비밀게시판"),
    GRADUATE("졸업생게시판"),
    ISSUE("시사·이슈"),
    INFO("정보게시판"),
    EVENT("이벤트게시판"),
    PROMOTION("홍보게시판");
    private final String korName;

    SearchCategory(String korName) {
        this.korName = korName;
    }
}
