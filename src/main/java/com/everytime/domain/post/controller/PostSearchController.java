package com.everytime.domain.post.controller;

import com.everytime.domain.post.domain.enums.Category;
import com.everytime.domain.post.dto.request.PostSearchRequest;
import com.everytime.domain.post.dto.response.PostSearchPageResponse;
import com.everytime.domain.post.service.PostSearchService;
import com.everytime.global.exception.constant.SearchSuccessCode;
import com.everytime.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostSearchController {

    private final PostSearchService postSearchService;

    @GetMapping("/search")
    public BaseResponse<PostSearchPageResponse> search(
            @RequestParam String category,
            @RequestParam String keyword,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        Category parsedCategory = Category.valueOf(category.trim().toUpperCase());
        String safeKeyword = (keyword == null) ? "" : keyword.trim();

        PostSearchRequest request = PostSearchRequest.builder()
                .category(parsedCategory.name())
                .keyword(safeKeyword)
                .page(page)
                .size(size)
                .build();

        return BaseResponse.ok(
                SearchSuccessCode.GET_POST_SEARCH_RESULT.getMsg(),
                postSearchService.search(request)
        );
    }

}