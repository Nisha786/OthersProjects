package com.aartek.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.User;

@Repository
public class RegistrationRepository {
  
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public String addUserRepo(User user){
		String res = null;
		if(user!=null){
			hibernateTemplate.save(user);
			res = "Submit";
		}
		return res;
	}
}
