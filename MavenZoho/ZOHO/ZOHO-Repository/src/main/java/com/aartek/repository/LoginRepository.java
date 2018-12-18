package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.User;

@Repository
public class LoginRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public String checkLogin(User user) {
		System.out.println("Inside Login repository");
		/*System.out.println(user.getEmail());
		System.out.println(user.getPassword());*/
		String check = null;
		/*
		 * if(user!=null){ hibernateTemplate.save(user);
		 * System.out.println("Record Saved Succesfully"); }
		 */
		if(user.getEmail()!=null && user.getPassword()!=null){
		List<User> list = null;
		list = hibernateTemplate.find("from User u where u.email=? and u.password=?",user.getEmail(),user.getPassword());
		//System.out.println(list);
		if(list.size()>0){
		Iterator<User> it = list.iterator();
		while(it.hasNext()){
			User use = (User)it.next();
			if(use.getEmail().equals(user.getEmail()) && use.getPassword().equals(user.getPassword())){
				//System.out.println("User Valid");
				check = "User Valid";
			}
		}
		}else{
			//System.out.println("Invlalid");
			check = "User InValid";
		}
		
		}else{
			//System.out.println("User Is Null");
			check = "User null";
		}
		return check;
	}
}
