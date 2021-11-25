package com.example.demo.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "authority", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@Getter
@Setter
public class Authority implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6534950615400310162L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    
   
    

    @Override
    public String getAuthority() {
        return getName();
    }
}
