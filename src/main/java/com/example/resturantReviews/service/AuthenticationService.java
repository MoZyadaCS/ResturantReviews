package com.example.resturantReviews.service;

import com.example.resturantReviews.configuration.security.JwtService;
import com.example.resturantReviews.dto.LoginDto;
import com.example.resturantReviews.dto.LoginResponseDto;
import com.example.resturantReviews.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final JwtService jwtService;

    private final CustomerService customerService;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginDto loginDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        Customer customer = customerService.findByEmail(loginDto.getEmail()).orElseThrow();
        String token = jwtService.generateToken(customer);
        return LoginResponseDto.builder()
                .customerID(customer.getId())
                .email(customer.getEmail())
                .token(token).build();
    }
}
