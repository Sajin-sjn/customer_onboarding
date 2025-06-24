package com.acabes.bank.customer_onboarding.controllers;

import com.acabes.bank.customer_onboarding.DTOs.CustomerDTO;
import com.acabes.bank.customer_onboarding.entities.Customer;
import com.acabes.bank.customer_onboarding.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    // constructor to auto-inject  CustomerService object
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/signUp")
    public ResponseEntity< Map<String, CustomerDTO>> addCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.createCustomer(customer);
        CustomerDTO savedCustomerDTO = new CustomerDTO(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("New Customer Created", savedCustomerDTO));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Map<String, Object>> getCustomer(@PathVariable String customerId){

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Customer", "No Customer Found"));
        }
        CustomerDTO customerDTO = new CustomerDTO(customer);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Customer", customerDTO));
    }
}
