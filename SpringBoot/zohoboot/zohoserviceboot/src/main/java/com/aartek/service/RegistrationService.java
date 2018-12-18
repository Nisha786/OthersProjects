package com.aartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository resRepo;

	public String registrationService(User user) {
		System.out.println(user.getFirstName());
		return resRepo.registrationRepository(user);
	}

}
