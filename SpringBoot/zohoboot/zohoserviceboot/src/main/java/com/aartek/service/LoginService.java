package com.aartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepo;

	public User getLogin(User user) {
		User user1 = loginRepo.checkLoginRepo(user);
		System.out.println("Intercpetor called");
		//System.out.println(user.getEmail() + "---" + user.getPassword());
		return user1;
	}
}
