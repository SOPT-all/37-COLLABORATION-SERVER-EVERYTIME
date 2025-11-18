package com.everytime.domain.review.controller;

import com.everytime.domain.review.dto.response.ReviewResponse;
import com.everytime.domain.review.service.ReviewService;
import com.everytime.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public BaseResponse<List<ReviewResponse>> getReviews() {
        List<ReviewResponse> reviews = reviewService.getReviews();
        return BaseResponse.ok("강의평 조회 성공", reviews);
    }
}
