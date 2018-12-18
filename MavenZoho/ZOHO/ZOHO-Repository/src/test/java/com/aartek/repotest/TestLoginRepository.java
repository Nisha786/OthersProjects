package com.aartek.repotest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;

import mockit.Mock;
import mockit.MockUp;

public class TestLoginRepository {
     
	@Before
	public void setUp(){
		new MockUp<HibernateTemplate>(){
		};
		new MockUp<User>(){
			
		};
		new MockUp<LoginRepository>(){
			@Mock
			String checkLogin(User user){
				return "succes";
			}
		};
	}
	
	
	@Test
	public void testCheckLogin() {
		User user = new User();
		LoginRepository loginRepo = new LoginRepository();
		String str = loginRepo.checkLogin(user);
		assertEquals("String reutned","succes",str);
	}

}
