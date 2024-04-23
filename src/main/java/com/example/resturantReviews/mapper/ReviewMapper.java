package com.example.resturantReviews.mapper;


import com.example.resturantReviews.dto.AddReviewDto;
import com.example.resturantReviews.dto.ReviewResponseDto;
import com.example.resturantReviews.model.Review;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReviewMapper {


    public Review toReviewEntity(AddReviewDto addReviewDto){
        return Review.builder()
                .comment(addReviewDto.getComment())
                .rating(addReviewDto.getRating())
                .timeAdded(LocalDateTime.now())
                .build();
    }

    public ReviewResponseDto toResponseDto(Review review){
        return ReviewResponseDto.builder()
                .comment(review.getComment())
                .rating(review.getRating())
                .timeAdded(review.getTimeAdded())
                .customerName(review.getCustomer().getName())
                .restaurantName(review.getRestaurant().getName())
                .build();
    }
}
