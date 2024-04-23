package com.example.resturantReviews.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @Size(min = 8,max = 32,message = "password should be between 8 and 32 digits or characters")
    private String password;
}
