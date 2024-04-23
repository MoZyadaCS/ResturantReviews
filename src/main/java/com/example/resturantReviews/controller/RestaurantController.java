package com.example.resturantReviews.controller;


import com.example.resturantReviews.dto.CreateRestaurantDto;
import com.example.resturantReviews.dto.RestaurantResponseDto;
import com.example.resturantReviews.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurant(@Valid @RequestBody CreateRestaurantDto createRestaurantDto){
        this.restaurantService.createRestaurant(createRestaurantDto);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants(){
        return new ResponseEntity<>(this.restaurantService.findAllRestaurants(),HttpStatus.OK);
    }
}
