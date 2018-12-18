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
		userRepository.save(user);
		System.out.println("Record Inserted");
		return "Record Inserted";
	}

	public List<User> checkLogin(User user) {
		List<User> list = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

		return list;
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

}
