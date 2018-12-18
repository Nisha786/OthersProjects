package com.aartek.model2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCTID")
	private Integer productId;
	@Column(name = "PRODUCTNAME")
	private String productname;
	@Column(name = "DESCRIPTION")
	private String productDescription;
	@Column(name = "PRICE")
	private String price;
	@Column(name = "NUMBEROFPRODUCTS")
	private String numberOfProducts;

	@Column(name = "FILENAME")
	private String fileName;
	
	@Transient
	private MultipartFile imagefile;

	public MultipartFile getImagefile() {
		return imagefile;
	}

	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(String numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
