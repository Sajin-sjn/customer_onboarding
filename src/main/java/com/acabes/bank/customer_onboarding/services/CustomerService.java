package com.acabes.bank.customer_onboarding.services;

import com.acabes.bank.customer_onboarding.entities.Customer;
import com.acabes.bank.customer_onboarding.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Slf4j
@Service
public class CustomerService  {

    private final CustomerRepository customerRepository;


//    private static final String PREFIX = "CUST";
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int RANDOM_LENGTH = 6;

    private final SecureRandom random = new SecureRandom();

    // CustomerId generation
    public String generateCustomerId() {
        StringBuilder sb = new StringBuilder();
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
        log.info("Customer created successfully");
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        log.info("All Customers created successfully");
        return customerRepository.findAll();
    }

    public Customer getCustomer(String id){
        log.info("Customer found successfully using id={}", id);
        return customerRepository.findById(id).orElse(null);
    }

    public Customer getCustomerByPhoneNumber(String phoneNumber){
        log.info("Customer found successfully using phone number " + phoneNumber);
        return customerRepository.findByCustomerPhone(phoneNumber).orElse(null);
    }



}
