package com.acabes.bank.customer_onboarding.entities;


import lombok.Data;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


// This is the customer Entity
@Component
@ToString
@Data
@Document(collection = "customer")
public class Customer {

    @Id
    private String customerId;

    private  String customerName;

    private  String customerDOB;

    private  String customerGender;

    private  String customerEmail;

    @Indexed(unique = true)
    private  String customerPhone;

    private  CustomerAddress customerAddress;

    private  String nationality;

    private BigDecimal customerIncome;

    private  String customerPanNumber;

    private  String customerAadharNumber;

    private  String password;

}
