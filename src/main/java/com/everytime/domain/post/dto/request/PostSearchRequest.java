package com.everytime.domain.post.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSearchRequest {

    private String category;
    private String keyword;
    private Integer page;
    private Integer size;

    @Builder
    public PostSearchRequest(String category, String keyword, Integer page, Integer size) {
        this.category = category;
        this.keyword = keyword;
        this.page = (page == null ? 0 : page);
        this.size = (size == null ? 20 : size);
    }
}

