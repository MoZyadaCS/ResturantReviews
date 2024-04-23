package com.example.resturantReviews.controller;


import com.example.resturantReviews.dto.AddReviewDto;
import com.example.resturantReviews.dto.ReviewResponseDto;
import com.example.resturantReviews.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("auth/review")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReview(@Valid @RequestBody AddReviewDto addReviewDto){
        this.reviewService.addReviewToRestaurant(addReviewDto);
    }

    @GetMapping("auth/review")
    public ResponseEntity<List<ReviewResponseDto>> getCustomerReviews(){
        return new ResponseEntity<>(this.reviewService.findAllReviewsForLoggedInCustomer(),HttpStatus.OK);
    }

    @GetMapping("review/restaurant/{restaurantId}")
    public ResponseEntity<List<ReviewResponseDto>> getAllReviewsForRestaurant(@PathVariable Long restaurantId ){
        return new ResponseEntity<>(this.reviewService.findAllReviewsForRestaurant(restaurantId),HttpStatus.OK);
    }



}
