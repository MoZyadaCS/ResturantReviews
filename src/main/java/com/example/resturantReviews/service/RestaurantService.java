package com.example.resturantReviews.service;


import com.example.resturantReviews.dto.CreateRestaurantDto;
import com.example.resturantReviews.dto.RestaurantResponseDto;
import com.example.resturantReviews.mapper.RestaurantMapper;
import com.example.resturantReviews.model.Restaurant;
import com.example.resturantReviews.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantMapper restaurantMapper;

    public void createRestaurant(CreateRestaurantDto createRestaurantDto){
        if(restaurantRepository.findByName(createRestaurantDto.getName()).isPresent()){
            throw new RuntimeException("Restaurant Already Created");
        }
        Restaurant restaurant = restaurantMapper.toRestaurantEntity(createRestaurantDto);
        restaurantRepository.save(restaurant);
    }

    public List<RestaurantResponseDto> findAllRestaurants(){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants
                .stream()
                .map(restaurantMapper::toRestaurantResponse)
                .collect(Collectors.toList());
    }

    public Restaurant getById(Long restaurantId){
        return this.restaurantRepository.findById(restaurantId).orElseThrow();
    }
}
