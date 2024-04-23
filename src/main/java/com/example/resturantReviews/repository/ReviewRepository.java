package com.example.resturantReviews.repository;

import com.example.resturantReviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {


    @Query(value = "select * from review where customer_id = ?1",nativeQuery = true)
    List<Review> findAllByCustomerId(Long customerId);

    @Query(value = "select * from review where restaurant_id = ?1",nativeQuery = true)
    List<Review> findAllForRestaurant(Long restaurantId);
}
