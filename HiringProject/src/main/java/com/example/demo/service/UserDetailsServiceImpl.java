package com.example.demo.service;




import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.example.demo.entity.Authority;
import com.example.demo.entity.User;
import com.example.demo.exception.CustomException;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.repository.UserRepository;

@Service
@ControllerAdvice
public class UserDetailsServiceImpl implements UserDetailsService,UserService 
{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	
	


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
	

	@Override
    public User create(User user) 
	{
        User userWithDuplicateUsername = userRepository.findByUsername(user.getUsername());
        if(userWithDuplicateUsername != null && user.getId()!=userWithDuplicateUsername.getId()) {
                     throw new CustomException("Duplicate username.:" +user.getUsername());
        }
        
        
        
        User user1 = new User();
        user1.setEmailId(user.getEmailId());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setUsername(user.getUsername());
        user1.setPassword(new BCryptPasswordEncoder(8).encode(user.getPassword()));
       
      //  Authority authority=new Authority();
        List<Object> list=new ArrayList<>();
        //list.add(user.getAuthorities());
        //authority.setName(user.getAuthorities());
         user.getAuthorities().stream().map(role->list.add(role));
        Authority authority=new Authority();
        authority.setName(user.getAuthorities().toString());
        authorityRepository.save(authority);
        user1.setAuthorities(user.getAuthorities());
        userRepository.save(user1);
        return user;
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

