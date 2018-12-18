package com.aartek.impl;

import org.springframework.stereotype.Component;

@Component
public interface Customer {
	public void addCustomer();

	public String addCustomerReturned();
	
	public void addCustomerThrow() throws Exception;
	
	public void addCustomerAround(String name);
}
