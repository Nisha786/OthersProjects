package com.aartek.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aartek.model.User;
@Repository
public interface UserRepository{
   public String addUser(User user);
   public List<User> findAll();
   public List<User> fidByEmailPassword(User user);
}
