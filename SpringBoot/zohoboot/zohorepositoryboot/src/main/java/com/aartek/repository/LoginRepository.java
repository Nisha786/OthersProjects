package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.User;

@Repository
public class LoginRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("deprecation")
	public User checkLoginRepo(User user) {
		// System.out.println(user.getEmail()+"---"+user.getPassword());
		// user.setEmail(user.getEmail());
		// user.setPassword(user.getPassword());
		String email = null;
		String pass = null;
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) hibernateTemplate.find("from User u where u.email=? and u.password=?",user.getEmail(),user.getPassword());
		if(list.size()>0){
		Iterator<User> it = list.iterator();
		while(it.hasNext()){
			User u1 = (User)it.next();
			email = u1.getEmail();
			pass =  u1.getPassword();
		}
		user.setEmail(email);
		user.setPassword(pass);
		}else{
			user.setEmail("1111");
			user.setPassword("11212");
		}
		return user;
	}
}
