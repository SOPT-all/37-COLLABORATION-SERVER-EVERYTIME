package com.everytime.domain.post.dto.response;

import com.everytime.domain.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostSearchResponse {

    private String category;
    private String keyword;

    private Long id;
    private String title;
    private String content;
    private int likeCount;
    private int commentCount;
    private LocalDateTime createdAt;
    private boolean isAnonymous;
    private String nickname;

    public static PostSearchResponse from(Post post, String category, String keyword){
        return PostSearchResponse.builder()
                .category(category)
                .keyword(keyword)
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .likeCount(post.getLikeCount())
                .commentCount(post.getCommentCount())
                .createdAt(post.getCreatedAt())
                .isAnonymous(post.isAnonymous())
                .nickname(post.getNickname())
                .build();
    }
}
