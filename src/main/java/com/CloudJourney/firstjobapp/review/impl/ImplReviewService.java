package com.CloudJourney.firstjobapp.review.impl;

import com.CloudJourney.firstjobapp.company.Company;
import com.CloudJourney.firstjobapp.company.CompanyRepository;
import com.CloudJourney.firstjobapp.company.CompanyService;
import com.CloudJourney.firstjobapp.review.Review;
import com.CloudJourney.firstjobapp.review.ReviewService;
import com.CloudJourney.firstjobapp.review.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplReviewService implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;
    private final CompanyRepository companyRepository;

    public ImplReviewService(ReviewRepository reviewRepository, CompanyService companyService, CompanyRepository companyRepository) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Review> getReviews(Long companyId) {
        List<Review> reviews=reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Boolean AddReview(Long companyId, Review review) {
        Company company = companyService.GetCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
       List<Review> reviews= reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Boolean updateReview(Long companyId, Long reviewId, Review updatedreview) {
        if(companyService.GetCompanyById(companyId)!=null){
            updatedreview.setCompany(companyService.GetCompanyById(companyId));
            updatedreview.setId(reviewId);
            reviewRepository.save(updatedreview);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.GetCompanyById(companyId)!=null &&
        reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company=review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
