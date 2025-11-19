package com.everytime.domain.review.dto.response;

import com.everytime.domain.review.domain.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponse {
    private Long id;
    private int rate;
    private String lecture;
    private String content;

    public static ReviewResponse from(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .rate(review.getRate())
                .lecture(review.getLecture())
                .content(review.getContent())
                .build();
    }
}
