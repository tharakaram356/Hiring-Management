package com.example.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class AuthorityDto {
	
	private Long id;
	private String name;
	
	
	public AuthorityDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public AuthorityDto(String name) {
		super();
		this.name = name;
	}
	public AuthorityDto() {
		super();
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AuthorityDto [id=" + id + ", name=" + name + "]";
	}
	

}
