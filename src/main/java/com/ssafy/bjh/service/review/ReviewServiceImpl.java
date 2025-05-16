package com.ssafy.bjh.service.review;

import com.ssafy.bjh.model.dto.Review;
import org.springframework.stereotype.Service;
import com.ssafy.bjh.model.dao.review.ReviewDao;
import lombok.RequiredArgsConstructor;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewDao reviewDao;

    @Override
    public List<Review> getAllReviews(int videoId) {
        return reviewDao.getAllReviews(videoId);
    }

    @Override
    public List<Review> searchReviews(int videoId, String searchContent) {
        return reviewDao.getSearchReviews(videoId, searchContent);
    }

    @Override
    public Review getReviewById(int reviewId) {
        return reviewDao.getReviewById(reviewId);
    }

    @Override
    public void addReview(Review review) {
        reviewDao.addReview(review);
    }

    @Override
    public void updateReview(int reviewId, String title, String content) {
        reviewDao.updateReview(reviewId, title, content);
    }

    @Override
    public void deleteReview(int reviewId) {
        reviewDao.deleteReview(reviewId);
    }

    @Override
    public void incrementClickCount(int reviewId) {
        reviewDao.updateCount(reviewId);
    }
}
