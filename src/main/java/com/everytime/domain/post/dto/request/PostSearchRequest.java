package com.everytime.domain.post.dto.request;

import com.everytime.domain.post.domain.enums.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSearchRequest {

    private Category category;
    private String keyword;
    private int page;
    private int size;

    @Builder
    public PostSearchRequest(Category category, String keyword, int page, int size) {
        this.category = category;
        this.keyword = keyword;
        this.page = page;
        this.size = size;
    }
}

