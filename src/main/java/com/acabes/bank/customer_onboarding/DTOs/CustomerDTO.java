package com.acabes.bank.customer_onboarding.DTOs;

import com.acabes.bank.customer_onboarding.entities.Customer;
import com.acabes.bank.customer_onboarding.entities.CustomerAddress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

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

    @Getter
    @Setter
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
    private CustomerAddress customerAddress;

    @Getter @Setter
    private  String nationality;

    @Getter @Setter
    private  String customerIncome;

    @Getter @Setter
    private  String customerPanNumber;

    @Getter @Setter
    private  String customerAadharNumber;

}
