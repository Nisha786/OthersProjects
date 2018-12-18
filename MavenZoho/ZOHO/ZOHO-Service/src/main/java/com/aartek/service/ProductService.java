package com.aartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model2.Products;
import com.aartek.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository proRepository;

	public void addRecords(Products product) {
		/*System.out.println("Inside Product service");
		System.out.println(product.getProductname());*/
		proRepository.addProducts(product);

	}

	public Object getProducts() {
		//System.out.println("Getting all records");
		return proRepository.getAllProducts();
	}

}
