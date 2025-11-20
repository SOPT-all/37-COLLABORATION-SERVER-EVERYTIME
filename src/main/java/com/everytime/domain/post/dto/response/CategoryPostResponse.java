package com.everytime.domain.post.dto.response;

import com.everytime.domain.post.domain.enums.Category;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CategoryPostResponse {
    private String category;
    private List<PostSummaryResponse> posts;

    public static CategoryPostResponse from(Category category, List<PostSummaryResponse> posts) {
        return CategoryPostResponse.builder()
                .category(category.getKorName())
                .posts(posts)
                .build();
    }
}
