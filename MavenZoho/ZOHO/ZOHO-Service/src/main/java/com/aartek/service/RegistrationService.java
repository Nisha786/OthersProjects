package com.aartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository registrationRepository;

	public void checkRegistration(User user) {
		/*System.out.println("Inside Service Registration  method");
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());*/
		registrationRepository.registration(user);

	}
	
}
