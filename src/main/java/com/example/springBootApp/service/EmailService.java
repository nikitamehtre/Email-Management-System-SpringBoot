package com.example.springBootApp.service;
import java.util.List;
import com.example.springBootApp.entity.Email;

public interface EmailService {
	Email saveEmail(Email email);
	List<Email> getAllEmail();
	Email getEmailById(long id);
	Email updateEmail(Email email, long id);
	void deleteEmail(long id);
//	CRUD : Create Read Update Delete
	List<Email> getEmailBySubject(String subject);
	List<Email> getEmailsBySenderId(long user_id);
	
}