package com.ssafy.bjh.controller.video;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.bjh.model.dto.Video;
import com.ssafy.bjh.service.review.ReviewService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import com.ssafy.bjh.model.dto.Review;
import com.ssafy.bjh.model.dto.User;

import org.springframework.stereotype.Service;
import com.ssafy.bjh.model.dao.review.ReviewDao;
import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
@CrossOrigin
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{videoId}")
    public List<Review> getReviews(@PathVariable int videoId) {
        return reviewService.getAllReviews(videoId);
    }

    @GetMapping("/search")
    public List<Review> searchReviews(@RequestParam int videoId, @RequestParam String content) {
        return reviewService.searchReviews(videoId, content);
    }

    @GetMapping("/review/{reviewId}")
    public Review getReviewById(@PathVariable int reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody Review review, HttpSession session) {
    	

	    reviewService.addReview(review);
	    return ResponseEntity.ok("작성 완료");
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Void> updateReview(@PathVariable int reviewId, @RequestBody Review review) {
        reviewService.updateReview(reviewId, review.getTitle(), review.getContent());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable int reviewId) {
        reviewService.deleteReview(reviewId);
    }

    @PatchMapping("/{reviewId}/click")
    public void incrementClick(@PathVariable int reviewId) {
        reviewService.incrementClickCount(reviewId);
    }
}
