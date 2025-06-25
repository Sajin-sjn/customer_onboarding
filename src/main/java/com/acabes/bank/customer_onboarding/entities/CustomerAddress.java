package com.acabes.bank.customer_onboarding.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@Data
public class CustomerAddress {
    private String city;

    private String state;

    private String country;

    private String pincode;
}
