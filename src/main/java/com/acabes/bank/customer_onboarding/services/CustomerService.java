package com.acabes.bank.customer_onboarding.services;

import com.acabes.bank.customer_onboarding.entities.Customer;
import com.acabes.bank.customer_onboarding.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService  {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer){
       return customerRepository.save(customer);
    }

    public Customer getCustomer(String id){
        return customerRepository.findById(id).orElse(null);
    }
}
