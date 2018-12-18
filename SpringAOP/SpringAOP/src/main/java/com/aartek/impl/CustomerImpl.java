package com.aartek.impl;

import org.springframework.stereotype.Component;

@Component
public class CustomerImpl implements Customer {

	public void addCustomer() {
		System.out.println("Inside Add Customer");
	}

	public String addCustomerReturned() {
		System.out.println("Inside Add Customer Returned");
		return null;
	}

	public void addCustomerThrow() throws Exception {
		System.out.println("Inside Add Customer Throw return");
		int x = 10 / 0;
		// System.out.println(x);

	}

	public void addCustomerAround(String name) {
		System.out.println("addCustomerAround() is running, args : " + name);
	}

}
