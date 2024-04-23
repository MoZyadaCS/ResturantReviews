package com.example.resturantReviews.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotNull(message = "email cannot be null")
    @NotEmpty(message = "email cannot be empty")
    private String email;

    @NotNull(message = "password cannot be null")
    @Size(min=8,max=32,
            message = "password size should be between" +
                    " 8 and 32 digit or character")
    private String password;

}
