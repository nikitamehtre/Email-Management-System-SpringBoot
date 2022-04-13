package com.example.springBootApp.service;
import java.util.List;
import java.util.Set;

import com.example.springBootApp.entity.Email;
import com.example.springBootApp.entity.User;

public interface EmailService {
	Email saveEmail(Email email);
	List<Email> getAllEmail();
	Email getEmailById(long id);
	User getUserById(long id);
	Email updateEmail(Email email, long id);
	void deleteEmail(long id);
//	CRUD : Create Read Update Delete
	List<Email> getEmailBySubject(String subject);
	List<Email> getEmailsBySenderId(long user_id);
	List<Email> getEmailsByReceiverId(long user_id);
	Set<User> findByUserEmailIn(String[] emails);	
}