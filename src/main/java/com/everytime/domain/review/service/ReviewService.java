package com.everytime.domain.review.service;

import com.everytime.domain.review.dto.response.ReviewResponse;
import com.everytime.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewResponse> getRecentReviews() {
        return reviewRepository.findTop3ByOrderByCreatedAtDesc()
                .stream()
                .map(ReviewResponse::from)
                .toList();
    }
}
