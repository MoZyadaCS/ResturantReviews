package com.example.resturantReviews.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddReviewDto {

    private String comment;

    @Min(1)
    @Max(5)
    private Integer rating;

    @NotNull(message = "Restaurant id cannot be null")
    private Long restaurantId;


}
