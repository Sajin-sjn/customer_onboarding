package com.acabes.bank.customer_onboarding.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class CustomerAddress {
    @Getter @Setter
    private String city;

    @Getter @Setter
    private String state;

    @Getter @Setter
    private String country;

    @Getter @Setter
    private String pincode;
}
