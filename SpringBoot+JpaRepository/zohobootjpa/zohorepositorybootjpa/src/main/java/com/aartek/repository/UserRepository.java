package com.aartek.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aartek.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findByEmailAndPassword(String email,String password);
}
