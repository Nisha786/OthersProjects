package in.com.prestige.dto;

import java.io.Serializable;

public class ProductsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productID = 0;
	private String productname = null;
	private String status = null;
	private double price = 0.0;

	private String category = null;
	private int numberofproducts = 0;
	private String filename = null;
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	private String path = null;

	public int getNumberofproducts() {
		return numberofproducts;
	}

	public void setNumberofproducts(int numberofproducts) {
		this.numberofproducts = numberofproducts;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setProductName(String productname) {
		this.productname = productname;
	}

	public String getProductName() {
		return productname;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setProductId(int productID) {
		this.productID = productID;
	}

	public int getProductID() {
		return productID;
	}
}
