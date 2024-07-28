package com.CloudJourney.firstjobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Companies/{companyId}")
public class ReviewController {

   private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        Boolean isreviewsaved=reviewService.AddReview(companyId, review);
        if(isreviewsaved)
            return new ResponseEntity<>("Review added successfully",HttpStatus.OK);

        else
            return new ResponseEntity<>("Review not added",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,
            @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId
    , @PathVariable Long reviewId, @RequestBody Review review) {

        Boolean isupdated =reviewService.updateReview(companyId, reviewId, review);
        if(isupdated)
            return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not updated",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<String> deletereview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId){
        boolean isdeleted = reviewService.deleteReview(companyId,reviewId);
        if(isdeleted)
            return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not deleted",HttpStatus.BAD_REQUEST);
    }
}

