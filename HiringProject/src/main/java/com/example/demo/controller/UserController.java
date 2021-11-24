package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserDetailsServiceImpl;

@RestController
//@RequestMapping("api/v1")
public class UserController {
	

	private UserDetailsServiceImpl detailsServiceImpl; 
	
	
	
	
	public UserController(UserDetailsServiceImpl detailsServiceImpl) {

		this.detailsServiceImpl = detailsServiceImpl;
	}
	
	/*@GetMapping(value="user")
	public List<User> getUsers()
	{
		return detailsServiceImpl.getAll();
	}*/
	@GetMapping(value="/user")
    public List<User> getAll() {
        return detailsServiceImpl.getAll();
    }
	/*@RequestMapping(value="/user",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> create(@RequestBody User user) {
        detailsServiceImpl.create(user);
        HttpHeaders headers = new HttpHeaders();
        //Controller linkBuilder = linkTo(methodOn(UserDetailsServiceImpl.class).get(user.getId()));
       // headers.setLocation(linkBuilder.toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }*/
	
	

}
