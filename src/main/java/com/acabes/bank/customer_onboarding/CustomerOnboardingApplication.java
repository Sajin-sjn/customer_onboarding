package com.acabes.bank.customer_onboarding;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.acabes.bank.customer_onboarding.entities.Customer;
import com.acabes.bank.customer_onboarding.entities.CustomerAddress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CustomerOnboardingApplication {

	public static void main(String[] args) {
		 ApplicationContext  context =  SpringApplication.run(CustomerOnboardingApplication.class, args);
	}

}
