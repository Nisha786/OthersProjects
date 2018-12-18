package com.aartek.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aartek.impl.CustomerImpl;

public class TestCustomer {
	public static void main(String[] args) throws Exception {
     ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
     Customer cust = (Customer)context.getBean("customerImpl");
     //cust.addCustomer();
     //cust.addCustomerReturned();
    //cust.addCustomerThrow();
     cust.addCustomerAround("Deependra");
	}
}
