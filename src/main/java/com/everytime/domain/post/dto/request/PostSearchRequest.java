package com.everytime.domain.post.dto.request;

import com.everytime.domain.post.domain.enums.Category;
import com.everytime.domain.post.domain.enums.SearchCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSearchRequest {

    private SearchCategory searchCategory;
    private String keyword;
    private int page;
    private int size;

    @Builder
    public PostSearchRequest(SearchCategory searchCategory, String keyword, int page, int size) {
        this.searchCategory = searchCategory;
        this.keyword = keyword;
        this.page = page;
        this.size = size;
    }
}

