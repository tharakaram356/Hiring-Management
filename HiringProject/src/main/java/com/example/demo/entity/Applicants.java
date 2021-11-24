package com.example.demo.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="applicants")
public class Applicants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name",length = 30)
	private String name;
	private String gender;
	private String mobile;
	private String currentLocation;
	private String higherQualification;
	private String course;
	private String skills;
	private int passingYear;
	private String address;
	private Blob resume;
	
	@OneToOne(mappedBy = "applicants")
	private User user;
	

}
