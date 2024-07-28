package com.CloudJourney.firstjobapp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviews(Long companyId);
    Boolean AddReview(Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);
    Boolean updateReview(Long companyId, Long reviewId, Review review);
    Boolean deleteReview(Long companyId, Long reviewId);
}
