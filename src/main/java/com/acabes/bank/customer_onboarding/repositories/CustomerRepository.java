package com.acabes.bank.customer_onboarding.repositories;

import com.acabes.bank.customer_onboarding.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByCustomerPhone(String phoneNumber);
}
