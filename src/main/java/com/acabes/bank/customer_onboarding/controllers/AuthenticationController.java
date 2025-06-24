package com.acabes.bank.customer_onboarding.controllers;

import com.acabes.bank.customer_onboarding.DTOs.AuthenticationDTO;
import com.acabes.bank.customer_onboarding.DTOs.CustomerDTO;
import com.acabes.bank.customer_onboarding.services.AuthenticationService;
import com.acabes.bank.customer_onboarding.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class AuthenticationController {

    public final AuthenticationService authenticationService;

    public  AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody AuthenticationDTO authenticationDTO) {
        String customerId = authenticationDTO.getCustomerId();
        String password = authenticationDTO.getPassword();

        // On Successful authentication the customer details will be returned
        // On failure the appropriate error message is returned
        return authenticationService.authenticate(customerId, password);

    }
}

