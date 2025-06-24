package com.acabes.bank.customer_onboarding.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


// This is the customer Entity
@Component
@ToString
@Document(collection = "customer")
public class Customer {

    @Id
    @Getter @Setter
    private String customerId;

    @Getter @Setter
    private  String customerName;

    @Getter @Setter
    private  String customerDOB;

    @Getter @Setter
    private  String customerGender;

    @Getter @Setter
    private  String customerEmail;

    @Getter @Setter
    private  String customerPhone;

    @Getter @Setter
    private  CustomerAddress customerAddress;

    @Getter @Setter
    private  String nationality;

    @Getter @Setter
    private BigDecimal customerIncome;

    @Getter @Setter
    private  String customerPanNumber;

    @Getter @Setter
    private  String customerAadharNumber;

    @Getter @Setter
    private  String password;

}
