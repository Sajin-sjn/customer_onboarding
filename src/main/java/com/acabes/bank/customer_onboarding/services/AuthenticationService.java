package com.acabes.bank.customer_onboarding.services;

import com.acabes.bank.customer_onboarding.DTOs.CustomerDTO;
import com.acabes.bank.customer_onboarding.entities.Customer;
import com.acabes.bank.customer_onboarding.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationService {

    public final CustomerRepository customerRepository;

    public AuthenticationService(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Object> authenticate(String customerPhone, String password) {
        Customer customer = customerRepository.findByCustomerPhone(customerPhone).orElse(null);

        // If there is no customer with given {hone Number then return Invalid Customer Phone Number
        // Authentication Failed
        if(customer == null){
            System.out.println("Invalid Phone Number");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Phone Number");
        }
        // If the given password matches the password of customer from DB then return the customer Details
        // Authentication Successful
        if(password.equals(customer.getPassword())){
            log.info("Customer Details: " + customer);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new CustomerDTO(customer));
        }
        // If given password does not match the password of customer from DB return Invalid Credentials
        // Authentication Failed
        else {
            log.info("Invalid Password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        }
    }
}
