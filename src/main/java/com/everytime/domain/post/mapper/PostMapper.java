package com.everytime.domain.post.mapper;

import com.everytime.domain.post.domain.Post;
import com.everytime.domain.post.domain.enums.Category;
import com.everytime.domain.post.dto.response.CategoryPostResponse;
import com.everytime.domain.post.dto.response.PostSummaryResponse;
import com.everytime.domain.post.dto.response.RealtimePostResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostMapper {
    public PostSummaryResponse toPostSummaryResponse(Post post) {
        return PostSummaryResponse.from(post);
    }

    public List<PostSummaryResponse> toPostSummaryResponseList(List<Post> posts) {
        return posts.stream()
                .map(this::toPostSummaryResponse)
                .toList();
    }

    public CategoryPostResponse toCategoryPostResponse(Category category, List<Post> posts) {
        List<PostSummaryResponse> postDtos = toPostSummaryResponseList(posts);
        return CategoryPostResponse.from(category, postDtos);
    }

    public RealtimePostResponse toRealtimePostResponse(Post post) {
        return RealtimePostResponse.from(post);
    }
}
