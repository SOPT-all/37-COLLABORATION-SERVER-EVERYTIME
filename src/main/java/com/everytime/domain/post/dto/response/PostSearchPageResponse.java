package com.everytime.domain.post.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostSearchPageResponse {

    private int currentPage;
    private int totalPages;
    private int size;
    private int currentSize;
    private long totalSize;
    private boolean hasPrevious;
    private boolean hasNext;

    private List<PostSearchResponse> posts;
}
