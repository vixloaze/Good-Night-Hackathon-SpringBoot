package com.example.hackathon.review.controller;

import com.example.hackathon.global.dto.ResultResponse;
import com.example.hackathon.global.dto.code.ResultCode;
import com.example.hackathon.review.dto.ReviewChange;
import com.example.hackathon.review.dto.ReviewCreateDTO;
import com.example.hackathon.review.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/review")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ResultResponse> createReview(@RequestBody ReviewCreateDTO request) {
        reviewService.createReview(request);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.CREATE_REVIEW_SUCCESS));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResultResponse> updateReview(@RequestBody ReviewChange request) {
        reviewService.updateReview(request);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.UPDATE_REVIEW_SUCCESS));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultResponse> getReview(@PathVariable Long id) {
        reviewService.getReview(id);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.GET_REVIEW_SUCCESS , reviewService.getReview(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResultResponse> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.DELETE_REVIEW_SUCCESS));
    }

}
