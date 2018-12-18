package com.aartek.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.aartek.model.User;
@Repository
public class UserRepositoryImpl implements UserRepository {
	@PersistenceContext
	private EntityManager em;

	public String addUser(User user) {
		em.persist(user);
		System.out.println("Records Inserted");
		return "Records Inserted";
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return em.createQuery("select u from User u").getResultList();
	}

	public List<User> fidByEmailPassword(User user) {
		Query query = em.createQuery("from User u where u.email=:arg1 and u.password=:arg2");
		query.setParameter("arg1", user.getEmail());
		query.setParameter("arg2", user.getPassword());
		@SuppressWarnings("unchecked")
		List<User> list = query.getResultList();
		return list;
	}
	
	

}
