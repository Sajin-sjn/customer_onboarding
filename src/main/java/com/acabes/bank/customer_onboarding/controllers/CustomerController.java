package com.acabes.bank.customer_onboarding.controllers;

import com.acabes.bank.customer_onboarding.DTOs.CustomerDTO;
import com.acabes.bank.customer_onboarding.entities.Customer;
import com.acabes.bank.customer_onboarding.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService;

    // constructor to auto-inject  CustomerService object
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/signUp")
    public ResponseEntity< Map<String, Object>> addCustomer(@RequestBody Customer customer){
        try{

            if( customerService.getCustomerByPhoneNumber(customer.getCustomerPhone()) != null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", "Duplicate Phone Number"));
            }

            Customer savedCustomer = customerService.createCustomer(customer);
            CustomerDTO savedCustomerDTO = new CustomerDTO(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("New Customer Created", savedCustomerDTO));

        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("Message", "Something went wrong"));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllCustomers(){
        try{
            List<Customer> customers = customerService.getAllCustomers();
            if (customers == null || customers.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "No Customer Data Found"));
            }
            List<CustomerDTO> customerDTOs = new ArrayList<>();
            for (Customer customer : customers) {
                CustomerDTO customerDTO = new CustomerDTO(customer);
                customerDTOs.add(customerDTO);
            }

            System.out.println(customerDTOs + "////////////////////");

            return ResponseEntity.status(HttpStatus.OK).body(Map.of("Customers", customerDTOs));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("Message", "Something went wrong"));
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Map<String, Object>> getCustomer(@PathVariable String customerId){
        try{
            System.out.println("Received Customer Id: " + customerId);
            Customer customer = customerService.getCustomer(customerId);
            if (customer == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "No Customer Found"));
            }
            CustomerDTO customerDTO = new CustomerDTO(customer);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("Customer", customerDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("Message", "Something went wrong"));
        }
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<Map<String, Object>> getByphone(@PathVariable String phone){
        Customer customer = customerService.getCustomerByPhoneNumber(phone);
        if(customer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "No Customer Found"));
        } else {
            CustomerDTO customerDTO = new CustomerDTO(customer);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("Customer", customerDTO));
        }
    }
}
