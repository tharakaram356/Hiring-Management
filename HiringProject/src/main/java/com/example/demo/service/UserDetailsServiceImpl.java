package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@Service
@ControllerAdvice
public class UserDetailsServiceImpl implements UserDetailsService,UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user != null) {
			return user;
		}

		throw new UsernameNotFoundException(username);
	}
	
	@Transactional(readOnly = true)
	 public List<User> getAll() {
		 return userRepository.findAll();
	 }
	
	@Transactional
	public void create(User user) {

		userRepository.save(user);
	}
	
	@Transactional
	public User update(User userdto) {
		return userRepository.save(userdto);
	}
	
	@Transactional
	public void delete(Long id) {
	 userRepository.delete(id);
	}
	@Transactional
	public void delete(User user) {
		userRepository.delete(user);
	}

}

