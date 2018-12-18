package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.User;

@Repository
public class RegistrationRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void registration(User user) {
		/*System.out.println("Inside Registation Controller");
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());*/
		if (user != null) {
			hibernateTemplate.save(user);
			//System.out.println("User Regiterd");
		}
	}

	// For Check if Email All ready Exits
	@SuppressWarnings("unchecked")
	public String checkEmailIfExits(String email) {
		String mail = null;
		List<User> list = hibernateTemplate.find("from User u where u.email=?",email);
		Iterator<User> it = list.iterator();
		while(it.hasNext()){
			User user = (User)it.next();
			mail = user.getEmail();
		}
		return mail;
	}
}
