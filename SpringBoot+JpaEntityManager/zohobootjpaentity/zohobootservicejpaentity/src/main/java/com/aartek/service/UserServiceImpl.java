package com.aartek.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public String addUser(User user) {
		return userRepository.addUser(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> checkLogin(User user) {
		return null;
	}

	

}
