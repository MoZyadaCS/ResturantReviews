package com.example.resturantReviews.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewResponseDto {

    private String comment;

    private int rating;

    private LocalDateTime timeAdded;

    private String restaurantName;

    private String customerName;
}
