package com.aartek.dto;

public class CustomerDTO {
   private Integer custmerId;
   private String customerName;
	private String address;

	public Integer getCustmerId() {
		return custmerId;
	}

	public void setCustmerId(Integer custmerId) {
		this.custmerId = custmerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
