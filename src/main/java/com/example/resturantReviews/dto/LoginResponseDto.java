package com.example.resturantReviews.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDto {
    private Long customerID;

    private String email;
    private String token;

}
