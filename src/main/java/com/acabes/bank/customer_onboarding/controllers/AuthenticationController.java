package com.acabes.bank.customer_onboarding.controllers;

import com.acabes.bank.customer_onboarding.DTOs.AuthenticationDTO;
import com.acabes.bank.customer_onboarding.DTOs.CustomerDTO;
import com.acabes.bank.customer_onboarding.services.AuthenticationService;
import com.acabes.bank.customer_onboarding.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    public final AuthenticationService authenticationService;

    public  AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody AuthenticationDTO authenticationDTO) {
        String customerPhone = authenticationDTO.getCustomerPhone();
        String password = authenticationDTO.getPassword();
        log.info("Received request to authenticate with customer phone : " + customerPhone);
        // On Successful authentication the customer details will be returned
        // On failure the appropriate error message is returned
        return authenticationService.authenticate(customerPhone, password);

    }
}

