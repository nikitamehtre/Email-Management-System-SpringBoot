package com.example.springBootApp.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "emails")
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;

	@Column
	private String subject;

	@Column
	private String body;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "sender_id", referencedColumnName = "id")
	private User sender;

	@ManyToMany(targetEntity = User.class)
	@JoinTable(name = "email_receivers", 
	joinColumns = @JoinColumn(name = "email_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "receiver_id", referencedColumnName = "id"))
	Set<User> receivers;

}
