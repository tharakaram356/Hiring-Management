package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AuthorityDto;
import com.example.demo.entity.Authority;

public interface AuthorityService 
{
	
	AuthorityDto create(AuthorityDto authorityDto);
	List<AuthorityDto> findByName(String name);
	
	AuthorityDto update(AuthorityDto authorityDto);
	
	void delete(String name);

}
