package com.everytime.domain.post.domain.enums;

import com.everytime.global.exception.CustomException;
import com.everytime.global.exception.constant.SearchErrorCode;
import lombok.Getter;

@Getter
public enum SearchCategory {

    ALL("전체", null),
    FREE("자유게시판", Category.FREE),
    SECRET("비밀게시판", Category.SECRET),
    GRADUATE("졸업생게시판", Category.GRADUATE),
    ISSUE("시사·이슈", Category.ISSUE),
    INFO("정보게시판", Category.INFO),
    EVENT("이벤트게시판", Category.EVENT),
    PROMOTION("홍보게시판", Category.PROMOTION);

    private final String korName;
    private final Category mappedCategory;

    SearchCategory(String korName, Category mappedCategory) {
        this.korName = korName;
        this.mappedCategory = mappedCategory;
    }

    public static SearchCategory from(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new CustomException(SearchErrorCode.CATEGORY_REQUIRED);
        }

        try {
            return SearchCategory.valueOf(value.trim().toUpperCase());
        } catch (Exception e) {
            throw new CustomException(SearchErrorCode.CATEGORY_INVALID);
        }
    }
}
