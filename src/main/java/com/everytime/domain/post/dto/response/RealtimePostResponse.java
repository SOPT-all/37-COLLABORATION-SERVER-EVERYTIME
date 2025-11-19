package com.everytime.domain.post.dto.response;

import com.everytime.domain.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RealtimePostResponse {
    private Long id;
    private String category;
    private String title;
    private String content;
    private int likeCount;
    private int commentCount;

    public static RealtimePostResponse from(Post post){
        return RealtimePostResponse.builder()
                .id(post.getId())
                .category(post.getCategory().getKorName())
                .title(post.getTitle())
                .content(post.getContent())
                .likeCount(post.getLikeCount())
                .commentCount(post.getCommentCount())
                .build();
    }
}
