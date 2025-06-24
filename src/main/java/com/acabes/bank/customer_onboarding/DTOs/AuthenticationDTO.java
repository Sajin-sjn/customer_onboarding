package com.acabes.bank.customer_onboarding.DTOs;

import lombok.Getter;
import lombok.Setter;

public class AuthenticationDTO {
    @Getter @Setter
    private String customerId;
    @Getter @Setter
    private String password;
}
