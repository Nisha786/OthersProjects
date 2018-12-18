package com.aartek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.Products;
import com.aartek.repository.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	private ProductsRepository proRepository;;

	public String productsAddService(Products product) {
		//System.out.println(user.getFirstName());
		return proRepository.productsRepository(product);
	}
	
	public Products getProducts(Products products){
		return products;
	}
	
	public List<Products> getAllProducts(){
		return proRepository.getAllProducts();
	}
	
	public String deleteRecordById(Products product){
		return proRepository.deletRecordById(product);
	}
	
	public Products findById(Integer id){
		Products product = proRepository.findById(id);
		return product;
	}
	
	public String updateRecord(Products pro){
		proRepository.updateRecord(pro);
		return "update";
	}

}
