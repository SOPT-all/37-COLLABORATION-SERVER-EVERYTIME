package com.everytime.domain.post.dto.response;

import com.everytime.domain.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class PostSummaryResponse {
    private Long id;
    private String title;
    private LocalDateTime createdAt;

    public static PostSummaryResponse from(Post post){
        return PostSummaryResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
