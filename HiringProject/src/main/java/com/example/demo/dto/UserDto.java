package com.example.demo.dto;

import java.util.Collection;
import java.util.List;

import com.example.demo.entity.Authority;

public class UserDto {

    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailId;
    
    private Collection<String> role;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    

    public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	

	

	

	

	

	public Collection<String> getRole() {
		return role;
	}

	public void setRole(Collection<String> role) {
		this.role = role;
	}

	@Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                " ,Role ='" +role+'\''+
                '}';
    }
	
	
    
}
