package com.everytime.domain.review.dto.response;

import com.everytime.domain.review.domain.Review;

public record ReviewResponse(
        int rate,
        String lecture,
        String content
) {
    public static ReviewResponse from(Review review) {
        return new ReviewResponse(
                review.getRate(),
                review.getLecture(),
                review.getContent()
        );
    }
}
