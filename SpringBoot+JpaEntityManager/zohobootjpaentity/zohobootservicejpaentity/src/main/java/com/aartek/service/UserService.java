package com.aartek.service;

import java.util.List;

import com.aartek.model.User;

public interface UserService {
  public String addUser(User user);
  public List<User> findAll();
  public List<User> checkLogin(User user);
}
