package com.aartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;



@Service
public class LoginService {
	@Autowired
    private LoginRepository loginRepository;
    
	public String checkLogin(User user){
		System.out.println("Inside Login Service method");
		/*System.out.println(user.getEmail());
		System.out.println(user.getPassword());*/
		String check = loginRepository.checkLogin(user);
		String checkLogin = null;
		if(check.equals("User Valid")){
			checkLogin = "User Valid";
		}
		return checkLogin;
	}
}
