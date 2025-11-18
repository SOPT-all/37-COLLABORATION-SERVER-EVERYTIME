package com.everytime.domain.review.dto.response;

import com.everytime.domain.review.domain.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponse {

    private int rate;
    private String lecture;
    private String content;

    public static ReviewResponse from(Review review) {
        return ReviewResponse.builder()
                .rate(review.getRate())
                .lecture(review.getLecture())
                .content(review.getContent())
                .build();
    }
}
