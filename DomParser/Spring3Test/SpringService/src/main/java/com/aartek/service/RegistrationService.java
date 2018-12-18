package com.aartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repository.RegistrationRepository;

@Service
public class RegistrationService {
    @Autowired
	private RegistrationRepository regRepo;
    
	public String addUserService(User user)
	{   
		String res = null;
		if(user!=null){
			res = regRepo.addUserRepo(user);
		}
		return res;
	}
}
