package com.example.springBootApp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	@Column
	private boolean active;
	@Column
	private String roles;
	
//	@ManyToMany(mappedBy = "receivers")
//	Set<Email> receivedEmails;
	
//	@JsonManagedReference
//	@OneToMany(mappedBy = "sender")
//	private Set<Email> sentEmails;

}
