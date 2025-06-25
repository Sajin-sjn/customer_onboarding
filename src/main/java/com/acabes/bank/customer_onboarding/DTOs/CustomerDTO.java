package com.acabes.bank.customer_onboarding.DTOs;

import com.acabes.bank.customer_onboarding.entities.Customer;
import com.acabes.bank.customer_onboarding.entities.CustomerAddress;
import lombok.Data;

@Data
public class CustomerDTO {

    CustomerDTO() {
    }
    public CustomerDTO(Customer customer) {

        this.customerId = customer.getCustomerId();
        this.customerDOB = customer.getCustomerDOB();
        this.customerGender = customer.getCustomerGender();
        this.customerName = customer.getCustomerName();
        this.customerEmail = customer.getCustomerEmail();
        this.customerPhone = customer.getCustomerPhone();
        this.customerAddress = customer.getCustomerAddress();
        this.nationality = customer.getNationality();
        this.customerIncome = String.valueOf(customer.getCustomerIncome());
        this.customerPanNumber = customer.getCustomerPanNumber();
        this.customerAadharNumber = customer.getCustomerAadharNumber();

    }

    private String customerId;

    private  String customerName;

    private  String customerDOB;

    private  String customerGender;

    private  String customerEmail;

    private  String customerPhone;

    private CustomerAddress customerAddress;

    private  String nationality;

    private  String customerIncome;

    private  String customerPanNumber;

    private  String customerAadharNumber;

}
