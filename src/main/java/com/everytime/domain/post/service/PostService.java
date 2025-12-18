package com.everytime.domain.post.service;

import com.everytime.domain.post.domain.Post;
import com.everytime.domain.post.domain.enums.Category;
import com.everytime.domain.post.dto.response.CategoryPostResponse;
import com.everytime.domain.post.dto.response.PostSummaryResponse;
import com.everytime.domain.post.dto.response.RealtimePostResponse;
import com.everytime.domain.post.mapper.PostMapper;
import com.everytime.domain.post.repository.PostRepository;
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
    private final PostMapper postMapper;

    public List<CategoryPostResponse> getAllPostsByCategory() {
        return Arrays.stream(Category.values())
                .filter(category -> category != Category.ALL)
                .map(category ->
                {
                    List<Post> posts = postRepository.findLatest4PostsByCategory(category);
                    return postMapper.toCategoryPostResponse(category, posts);
                })
                .toList();
    }

    public RealtimePostResponse getRealtimePost() {
        return postRepository.findTopRealtimePopularPost()
                .map(postMapper::toRealtimePostResponse)
                .orElse(null);
    }

    public List<PostSummaryResponse> getHotPosts() {
        List<Post> posts = postRepository.findTop4PopularPosts();
        return postMapper.toPostSummaryResponseList(posts);
    }
}