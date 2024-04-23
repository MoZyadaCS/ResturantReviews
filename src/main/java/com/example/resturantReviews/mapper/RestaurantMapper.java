package com.example.resturantReviews.mapper;


import com.example.resturantReviews.dto.CreateRestaurantDto;
import com.example.resturantReviews.dto.RestaurantResponseDto;
import com.example.resturantReviews.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {


    public Restaurant toRestaurantEntity(CreateRestaurantDto createRestaurantDto){
        return Restaurant.builder()
                .name(createRestaurantDto.getName())
                .address(createRestaurantDto.getAddress())
                .phoneNumber(createRestaurantDto.getPhone())
                .build();
    }

    public RestaurantResponseDto toRestaurantResponse(Restaurant restaurant){
        return RestaurantResponseDto.builder()
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .phoneNumber(restaurant.getPhoneNumber())
                .build();
    }
}
