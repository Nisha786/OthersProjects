package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.Products;
import com.aartek.model2.ProductImage;

@Transactional(isolation = Isolation.READ_COMMITTED)
@Repository
public class ProductsRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public String productsRepository(Products product) {
		hibernateTemplate.save(product);
		return "Inserted";
	}

	public List<Products> getAllProducts() {
		List<Products> list = hibernateTemplate.loadAll(Products.class);
		return list;
	}

	public String deletRecordById(Products product) {
		hibernateTemplate.delete(product);
		return "deleted";
	}

	public Products findById(Integer id) {
		Products pro = (Products) hibernateTemplate.get(Products.class, id);
		return pro;
	}

	public String updateRecord(Products pro) {
		hibernateTemplate.update(pro);
		return "update";
	}
}
