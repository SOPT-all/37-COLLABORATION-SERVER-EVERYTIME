package com.everytime.domain.post.service;

import com.everytime.domain.post.domain.Post;
import com.everytime.domain.post.domain.enums.Category;
import com.everytime.domain.post.dto.response.CategoryPostResponse;
import com.everytime.domain.post.dto.response.PostSummaryResponse;
import com.everytime.domain.post.dto.response.RealtimePostResponse;
import com.everytime.domain.post.repository.PostRepository;
import com.everytime.global.exception.CustomException;
import com.everytime.global.exception.constant.PostErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    public List<CategoryPostResponse> getAllPostsByCategory() {
        return Arrays.stream(Category.values())
                .map(category ->
                {
                    List<Post> posts = postRepository.findTop4ByCategoryOrderByCreatedAtDesc(category);

                    List<PostSummaryResponse> postDtos = posts.stream()
                            .map(PostSummaryResponse::from)
                            .toList();

                    return CategoryPostResponse.builder()
                            .category(category.getKorName())
                            .posts(postDtos)
                            .build();
                })
                .toList();
    }

    public RealtimePostResponse getRealtimePost() {
        Post post = postRepository.findTopByOrderByLikeCountDescCreatedAtDesc()
                .orElseThrow(()-> new CustomException(PostErrorCode.POST_NOT_FOUND));

        return RealtimePostResponse.from(post);
    }
}