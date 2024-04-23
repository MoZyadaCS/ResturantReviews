package com.example.resturantReviews.service;


import com.example.resturantReviews.dto.AddReviewDto;
import com.example.resturantReviews.dto.ReviewResponseDto;
import com.example.resturantReviews.mapper.ReviewMapper;
import com.example.resturantReviews.model.Customer;
import com.example.resturantReviews.model.Restaurant;
import com.example.resturantReviews.model.Review;
import com.example.resturantReviews.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    private final RestaurantService restaurantService;

    private final CustomerService customerService;
    public void addReviewToRestaurant(AddReviewDto addReviewDto){
        String email =  SecurityContextHolder.getContext().getAuthentication().getName();
        Customer customer = customerService.findByEmail(email).get();
        Review review = reviewMapper.toReviewEntity(addReviewDto);
        review.setCustomer(customer);
        Restaurant restaurant = restaurantService.getById(addReviewDto.getRestaurantId());
        review.setRestaurant(restaurant);
        reviewRepository.save(review);
    }

    public List<ReviewResponseDto> findAllReviewsForLoggedInCustomer(){
        String email =  SecurityContextHolder.getContext().getAuthentication().getName();
        Customer customer = customerService.findByEmail(email).get();
        List<Review> reviews = reviewRepository.findAllByCustomerId(customer.getId());
        return reviews.stream()
                .map(reviewMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<ReviewResponseDto> findAllReviewsForRestaurant(Long id){
        List<Review> reviews = reviewRepository.findAllForRestaurant(id);
        return reviews.stream()
                .map(reviewMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
