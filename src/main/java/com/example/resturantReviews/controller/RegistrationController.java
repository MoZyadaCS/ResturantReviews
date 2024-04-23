package com.example.resturantReviews.controller;


import com.example.resturantReviews.dto.CustomerDto;
import com.example.resturantReviews.dto.LoginDto;
import com.example.resturantReviews.dto.LoginResponseDto;
import com.example.resturantReviews.service.AuthenticationService;
import com.example.resturantReviews.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegistrationController {

    private final CustomerService customerService;

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewCustomer(@Valid @RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto){
        return new ResponseEntity<>(this.authenticationService.login(loginDto),HttpStatus.OK);
    }
}
