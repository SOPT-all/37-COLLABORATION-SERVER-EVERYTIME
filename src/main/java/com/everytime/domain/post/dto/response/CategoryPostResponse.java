package com.everytime.domain.post.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CategoryPostResponse {
    private String category;
    private List<PostSummaryResponse> posts;
}
