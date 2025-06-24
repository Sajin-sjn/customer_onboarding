package com.acabes.bank.customer_onboarding.services;

import com.acabes.bank.customer_onboarding.DTOs.CustomerDTO;
import com.acabes.bank.customer_onboarding.entities.Customer;
import com.acabes.bank.customer_onboarding.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public final CustomerRepository customerRepository;

    public AuthenticationService(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Object> authenticate(String customerId, String password) {
        Customer customer = customerRepository.findById(customerId).orElse(null);

        // If there is no customer with given Id then return Invalid Customer Id
        // Authentication Failed
        if(customer == null){
            System.out.println("wrong id");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid CustomerId");
        }
        // If the given password matches the password of customer from DB then return the customer Details
        // Authentication Successful
        if(password.equals(customer.getPassword())){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new CustomerDTO(customer));
        }
        // If given password does not match the password of customer from DB return Invalid Credentials
        // Authentication Failed
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        }
    }
}
