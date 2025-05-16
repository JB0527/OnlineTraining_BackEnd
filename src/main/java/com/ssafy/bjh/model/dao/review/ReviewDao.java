package com.ssafy.bjh.model.dao.review;

import com.ssafy.bjh.model.dto.Review;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewDao {
    List<Review> getAllReviews(int videoId);
    List<Review> getSearchReviews(@Param("videoId") int videoId, @Param("searchContent") String searchContent);
    Review getReviewById(int reviewId);
    void addReview(Review review);
    void updateReview(@Param("reviewId") int reviewId, @Param("title") String title, @Param("content") String content);
    void deleteReview(int reviewId);
    void updateCount(int reviewId);
}
