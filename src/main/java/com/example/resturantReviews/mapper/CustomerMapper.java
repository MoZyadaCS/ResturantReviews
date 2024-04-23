package com.example.resturantReviews.mapper;

import com.example.resturantReviews.dto.CustomerDto;
import com.example.resturantReviews.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    private final PasswordEncoder passwordEncoder;
    public Customer toCustomerEntity(CustomerDto customerDto){
        return Customer.builder()
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .password(passwordEncoder.encode(customerDto.getPassword()))
                .build();
    }
}
