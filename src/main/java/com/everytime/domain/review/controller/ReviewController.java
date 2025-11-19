package com.everytime.domain.review.controller;

import com.everytime.domain.review.dto.response.ReviewResponse;
import com.everytime.domain.review.service.ReviewService;
import com.everytime.global.exception.constant.ReviewSuccessCode;
import com.everytime.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public BaseResponse<List<ReviewResponse>> getRecentReviews() {
        List<ReviewResponse> response = reviewService.getRecentReviews();
        return BaseResponse.ok(ReviewSuccessCode.GET_RECENT_REVIEWS.getMsg(), response);
    }
}
