package com.example.demo.service;




import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Authority;
import com.example.demo.entity.AuthorityType;
import com.example.demo.entity.User;
import com.example.demo.exception.CustomException;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.repository.UserRepository;

import lombok.var;

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
	@Transactional
    public User create(UserDto userdto) 
	{
        User userWithDuplicateUsername = userRepository.findByUsername(userdto.getUsername());
        if(userWithDuplicateUsername != null && userdto.getId()!=userWithDuplicateUsername.getId()) {
            throw new CustomException("Duplicate username.:" +userdto.getUsername());
        }
       
       
      
        User user1 = new User();
        user1.setEmailId(userdto.getEmailId());
       // System.out.println("email ID"+userdto.getEmailId());
        user1.setFirstName(userdto.getFirstName());
        //System.out.println("firstName"+userdto.getFirstName());
        user1.setLastName(userdto.getLastName());
       // System.out.println("lastName"+userdto.getLastName());
        user1.setUsername(userdto.getUsername());
       // System.out.println("userName"+userdto.getUsername());
        user1.setPassword(new BCryptPasswordEncoder(8).encode(userdto.getPassword()));
        System.out.println("password"+userdto.getPassword());

        
        user1.setAuthorities(authorityRepository.find(userdto.getRole()));
     
        System.out.println("Authority"+userdto.getRole());
        System.out.println(userdto.getId());
        userRepository.save(user1);
       Authority authority=new Authority();
       
         authority.setName(userdto.getRole().toString());
        // authority.setId(userdto.getId());
         System.out.println(authority.getId()+"Authority Id");
         authorityRepository.save(authority);
        return user1;
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
	
	//final var user = (User) event.getSource();

}

