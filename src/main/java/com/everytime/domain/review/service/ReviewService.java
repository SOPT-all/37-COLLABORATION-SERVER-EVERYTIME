package com.everytime.domain.review.service;

import com.everytime.domain.review.dto.response.ReviewResponse;
import com.everytime.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewResponse> getReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(ReviewResponse::from)
                .toList();
    }
}
