package com.everytime.domain.post.service;

import com.everytime.domain.post.domain.Post;
import com.everytime.domain.post.domain.enums.Category;
import com.everytime.domain.post.dto.request.PostSearchRequest;
import com.everytime.domain.post.dto.response.PostSearchPageResponse;
import com.everytime.domain.post.dto.response.PostSearchResponse;
import com.everytime.domain.post.repository.PostSearchRepository;
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

        Category category = Category.valueOf(request.getCategory());
        String keyword = request.getKeyword();

        int page = request.getPage() == null ? 0 : request.getPage() - 1;
        int size = request.getSize() == null ? 20 : request.getSize();

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        Page<Post> result;

        // ALL: 카테고리 전체 대상 검색
        if (category == Category.ALL) {
            result = postSearchRepository.searchAll(keyword, pageable);

            // 특정 카테고리: 해당 category 내에서 검색
        } else {
            result = postSearchRepository.searchPosts(category, keyword, pageable);
        }

        // page가 전체 페이지 수보다 큰 경우 검사
        int totalPages = result.getTotalPages();
        int requestedPage = request.getPage();

        if (totalPages > 0 && requestedPage > totalPages) {
            throw new CustomException(SearchErrorCode.PAGE_OUT_OF_RANGE);
        }

        // DTO 변환
        List<PostSearchResponse> posts = result.getContent().stream()
                .map(post -> PostSearchResponse.from(
                        post,
                        category.name()
                ))
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
