/*package com.example.demo.service;

import java.util.List;

import org.apache.catalina.realm.AuthenticatedUserRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

/*public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	@Override
    @Transactional(readOnly = true)
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void create(UserDto user) {
	  repository.save(user);
		
	}

	@Override
	public User update(UserDto user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
		
	}

	@Override
	public void delete(UserDto user) {
		repository.delete(user);
		
	}

}*/
