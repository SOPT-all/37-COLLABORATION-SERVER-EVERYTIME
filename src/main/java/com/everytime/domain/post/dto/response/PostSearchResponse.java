package com.everytime.domain.post.dto.response;

import com.everytime.domain.post.domain.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostSearchResponse {

    private String category;
    private Long id;
    private String title;
    private String content;
    private int likeCount;
    private int commentCount;
    private LocalDateTime createdAt;
    @JsonProperty("isAnonymous")
    private boolean anonymous;
    private String nickname;

    public static PostSearchResponse from(Post post, String category){
        return PostSearchResponse.builder()
                .category(category)
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .likeCount(post.getLikeCount())
                .commentCount(post.getCommentCount())
                .createdAt(post.getCreatedAt())
                .anonymous(post.isAnonymous())
                .nickname(post.getNickname())
                .build();
    }
}
