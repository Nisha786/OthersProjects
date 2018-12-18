package in.com.prestige.dto;

import java.io.Serializable;

public class OrderListDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderid = 0;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	private String customersID = null;
	private int contactNo = 0;
	private String productName = null;
	private double price = 0.0;
	private int quantity = 0;

	public String getCustomersID() {
		return customersID;
	}

	public void setCustomersID(String customersID) {
		this.customersID = customersID;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
