package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="job_post")
public class JobPost {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE
	, generator = "user_sequence")
	@SequenceGenerator(name = "job_sequence", sequenceName = "job_sequence", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	@Column(name="request_title",nullable = false)
	private String requestTitle;
	@Column(name="job_title",nullable = false)
	private String jobTitle;
	@Column(name="discription")
	private String discription;
	@Column(name="key_skills",nullable = false)
	private String keySkills;
	@Column(name="")
	private String workExperiance;
	@Column(name="")
	private double annualSalary;
	@Column(name="")
	private String jobLocation;
	@Column(name="")
	private int numberOfVacancies;
	@Column(name="")
	private String requiterMail;

}
