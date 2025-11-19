package com.everytime.domain.post.controller;

import com.everytime.domain.post.dto.response.CategoryPostResponse;
import com.everytime.domain.post.dto.response.PostSummaryResponse;
import com.everytime.domain.post.dto.response.RealtimePostResponse;
import com.everytime.domain.post.service.PostService;
import com.everytime.global.exception.constant.PostSuccessCode;
import com.everytime.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @GetMapping()
    public BaseResponse<List<CategoryPostResponse>> getAllPosts() {
        List<CategoryPostResponse> response = postService.getAllPostsByCategory();
        return BaseResponse.ok(PostSuccessCode.GET_ALL_POSTS_BY_CATEGORY.getMsg(), response);
    }

    @GetMapping("/realtime")
    public BaseResponse<RealtimePostResponse> getRealtimePost() {
        RealtimePostResponse response = postService.getRealtimePost();
        return BaseResponse.ok(PostSuccessCode.GET_REALTIME_POST.getMsg(), response);
    }

    @GetMapping("/hot")
    public BaseResponse<List<PostSummaryResponse>> getHotPosts() {
        List<PostSummaryResponse> response = postService.getHotPosts();
        return BaseResponse.ok(PostSuccessCode.GET_HOT_POSTS.getMsg(), response);
    }

}
