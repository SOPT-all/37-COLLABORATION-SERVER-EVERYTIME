package com.everytime.domain.post.domain.enums;

import lombok.Getter;

@Getter
public enum Category {
    FREE("자유게시판"),
    GRADUATE("졸업생게시판"),
    ISSUE("시사·이슈"),
    EVENT("이벤트게시판"),
    PROFESSIONAL_EXAM("전문직 시험"),
    LAW_SCHOOL("로스쿨을 준비하는 아주대생 모임(로아모)"),
    CLUB("동아리·학회"),
    SECRET("비밀게시판"),
    FRESHMAN("새내기게시판"),
    INFO("정보게시판"),
    JOB_CAREER("취업·진로"),
    PUBLIC_OFFICER("공무원 준비생들"),
    PROMOTION("홍보게시판");

    private final String korName;

    Category(String korName) {
        this.korName = korName;
    }
}
