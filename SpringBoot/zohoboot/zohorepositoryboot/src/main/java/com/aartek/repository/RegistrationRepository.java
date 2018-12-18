package com.aartek.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.User;

@Transactional(isolation=Isolation.READ_COMMITTED)
@Repository
public class RegistrationRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;
    
	public String registrationRepository(User user){
		System.out.println(user.getFirstName());
		hibernateTemplate.save(user);
		System.out.println("Records Saved");
		return user.getLastname();
	}
}
