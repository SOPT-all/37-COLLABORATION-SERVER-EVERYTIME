package com.everytime.domain.post.service;

import com.everytime.domain.post.domain.Post;
import com.everytime.domain.post.domain.enums.Category;
import com.everytime.domain.post.domain.enums.SearchCategory;
import com.everytime.domain.post.dto.request.PostSearchRequest;
import com.everytime.domain.post.dto.response.PostSearchPageResponse;
import com.everytime.domain.post.dto.response.PostSearchResponse;
import com.everytime.domain.post.repository.PostSearchRepository;
import com.everytime.domain.post.utils.SearchCategoryUtils;
import com.everytime.global.exception.CustomException;
import com.everytime.global.exception.constant.SearchErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostSearchService {

    private final PostSearchRepository postSearchRepository;

    public PostSearchPageResponse search(PostSearchRequest request) {

        SearchCategory searchCategory = request.getSearchCategory();
        String keyword = request.getKeyword();

        int page = request.getPage() - 1;
        int size = request.getSize();
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        Page<Post> result;

        // 🔹 1) ALL 검색: 검색 가능한 8개 카테고리만 대상으로 검색
        if (searchCategory == SearchCategory.ALL) {
            List<Category> allowed = SearchCategoryUtils.allowedCategories();

            result = postSearchRepository.searchByCategories(
                    allowed,
                    keyword,
                    pageable
            );

            // 🔹 2) 특정 카테고리 검색
        } else {
            Category mapped = searchCategory.getMappedCategory();

            result = postSearchRepository.searchPosts(
                    mapped,
                    keyword,
                    pageable
            );
        }

        // page 범위 검증
        int totalPages = result.getTotalPages();
        if (totalPages > 0 && request.getPage() > totalPages) {
            throw new CustomException(SearchErrorCode.PAGE_OUT_OF_RANGE);
        }

        // DTO 변환
        List<PostSearchResponse> posts = result.getContent().stream()
                .map(PostSearchResponse::from)
                .toList();

        return PostSearchPageResponse.builder()
                .currentPage(result.getNumber() + 1)
                .totalPages(result.getTotalPages())
                .size(size)
                .currentSize(result.getNumberOfElements())
                .totalSize(result.getTotalElements())
                .hasPrevious(result.hasPrevious())
                .hasNext(result.hasNext())
                .posts(posts)
                .build();
    }
}
