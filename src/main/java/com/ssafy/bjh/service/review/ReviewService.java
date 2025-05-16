package com.ssafy.bjh.service.review;
import com.ssafy.bjh.model.dto.Review;
import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(int videoId);
    List<Review> searchReviews(int videoId, String searchContent);
    Review getReviewById(int reviewId);
    void addReview(Review review);
    void updateReview(int reviewId, String title, String content);
    void deleteReview(int reviewId);
    void incrementClickCount(int reviewId);
}
