package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
	
	public List<User> getAll();
	
	public void create(User user);
	
	public User update(User user);
	
	 public void delete(Long id);
	 
	 public void delete(User user);

}
