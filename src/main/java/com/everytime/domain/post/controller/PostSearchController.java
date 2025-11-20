package com.everytime.domain.post.controller;

import com.everytime.domain.post.domain.enums.Category;
import com.everytime.domain.post.dto.request.PostSearchRequest;
import com.everytime.domain.post.dto.response.PostSearchPageResponse;
import com.everytime.domain.post.service.PostSearchService;
import com.everytime.global.exception.CustomException;
import com.everytime.global.exception.constant.SearchErrorCode;
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
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        // category 검증
        if (category == null || category.trim().isEmpty()) {
            throw new CustomException(SearchErrorCode.CATEGORY_REQUIRED);
        }

        final Category parsedCategory;
        try {
            parsedCategory = Category.valueOf(category.trim().toUpperCase());
        } catch (Exception e) {
            throw new CustomException(SearchErrorCode.CATEGORY_INVALID);
        }

        // keyword 검증
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new CustomException(SearchErrorCode.KEYWORD_REQUIRED);
        }
        String safeKeyword = keyword.trim();
        if (safeKeyword.length() < 2) {
            throw new CustomException(SearchErrorCode.KEYWORD_TOO_SHORT);
        }


        if (page < 1) {
            throw new CustomException(SearchErrorCode.PAGE_INVALID);
        }
        if (size < 1) {
            throw new CustomException(SearchErrorCode.SIZE_INVALID);
        }

        // DTO로 변환
        PostSearchRequest request = PostSearchRequest.builder()
                .category(parsedCategory)
                .keyword(safeKeyword)
                .page(page)
                .size(size)
                .build();

        PostSearchPageResponse response = postSearchService.search(request);

        String message = (response.getTotalSize() == 0)
                ? SearchSuccessCode.GET_POST_SEARCH_EMPTY.getMsg()
                : SearchSuccessCode.GET_POST_SEARCH_RESULT.getMsg();

        return BaseResponse.ok(message, response);
    }
}
