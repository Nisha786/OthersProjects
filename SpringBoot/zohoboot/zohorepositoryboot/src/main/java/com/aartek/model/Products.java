package com.aartek.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.aartek.model2.ProductImage;

@Entity
@Table(name = "Products")
public class Products implements Serializable {
	private static final long serialVersionUID = -8175904234472366595L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId")
	private Integer productId;
	@Column(name = "productName")
	private String productName;
	@Column(name = "description")
	private String description;
	@Column(name = "noOfProducts")
	private String noOfProducts;
	@Column(name = "price")
	private String price;
    @Transient
	private MultipartFile imagefile;

	public MultipartFile getImagefile() {
		return imagefile;
	}

	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}

	@OneToMany(targetEntity = ProductImage.class, cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private List<ProductImage> proImg;

	public List<ProductImage> getProImg() {
		return proImg;
	}

	public void setProImg(List<ProductImage> proImg) {
		this.proImg = proImg;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(String noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
