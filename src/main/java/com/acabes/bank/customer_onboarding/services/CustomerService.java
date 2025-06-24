package com.acabes.bank.customer_onboarding.services;

import com.acabes.bank.customer_onboarding.entities.Customer;
import com.acabes.bank.customer_onboarding.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class CustomerService  {

    private final CustomerRepository customerRepository;


    private static final String PREFIX = "CUST";
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int RANDOM_LENGTH = 6;

    private final SecureRandom random = new SecureRandom();

    public String generateCustomerId() {
        StringBuilder sb = new StringBuilder(PREFIX);
        for (int i = 0; i < RANDOM_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString(); // e.g., CUSTA1B2C3
    }

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer){
        String customerId = generateCustomerId();
        customer.setCustomerId(customerId);
        return customerRepository.save(customer);
    }

    public Customer getCustomer(String id){
        return customerRepository.findById(id).orElse(null);
    }

}
