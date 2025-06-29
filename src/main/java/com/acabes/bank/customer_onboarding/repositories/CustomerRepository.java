package com.acabes.bank.customer_onboarding.repositories;

import com.acabes.bank.customer_onboarding.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByCustomerPhone(String phoneNumber);
}
