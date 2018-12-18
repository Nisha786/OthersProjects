package com.aartek.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model2.Products;



@Repository
public class ProductRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void addProducts(Products product) {
		System.out.println("Inside Product Repository");
		if (product != null) {
			hibernateTemplate.save(product);
			System.out.println("Records Saved");
		}
	}

	public List<Products> getAllProducts() {
		List<Products> list = hibernateTemplate.loadAll(Products.class);
		return list;
	}
}
