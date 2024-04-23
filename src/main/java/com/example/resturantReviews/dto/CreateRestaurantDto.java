package com.example.resturantReviews.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRestaurantDto {

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotNull(message = "address cannot be null")
    @NotEmpty(message = "address cannot be empty")
    private String address;
    @NotNull(message = "phone cannot be null")
    @NotEmpty(message = "phone cannot be empty")
    private String phone;
}
