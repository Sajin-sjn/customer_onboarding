package com.acabes.bank.customer_onboarding.DTOs;

import lombok.Data;
@Data
public class AuthenticationDTO {
    private String customerPhone;
    private String password;
}
