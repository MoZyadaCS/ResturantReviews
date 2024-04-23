package com.example.resturantReviews.service;

import com.example.resturantReviews.dto.CustomerDto;
import com.example.resturantReviews.mapper.CustomerMapper;
import com.example.resturantReviews.model.Customer;
import com.example.resturantReviews.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
	
	private final CustomerRepository customerRepository;

	private final CustomerMapper customerMapper;

	public Optional<Customer> getCustomerById(Long customerId) {
		return customerRepository.findById(customerId);
	}

	public void createCustomer(CustomerDto customerDto){
		Optional<Customer> optionalCustomer = customerRepository.findByEmail(customerDto.getEmail());
		if(optionalCustomer.isPresent()){
			throw new RuntimeException("Customer Has Account Associated With This Email");
		}
		customerRepository.save(customerMapper.toCustomerEntity(customerDto));
	}

	Optional<Customer> findByEmail(String email){
		return this.customerRepository.findByEmail(email);
	}

}
