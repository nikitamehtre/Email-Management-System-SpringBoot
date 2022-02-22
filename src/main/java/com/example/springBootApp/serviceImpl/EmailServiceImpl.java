package com.example.springBootApp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBootApp.entity.Email;
import com.example.springBootApp.exception.ResourceNotFound;
import com.example.springBootApp.repository.EmailRepository;
import com.example.springBootApp.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepository emailRepository;

	public EmailServiceImpl(EmailRepository emailRepository) {
		super();
		this.emailRepository = emailRepository;
	}

	@Override
	public Email saveEmail(Email email) {
		return emailRepository.save(email);
	}

	@Override
	public List<Email> getAllEmail() {
		return emailRepository.findAll();

	}

	@Override
	public Email getEmailById(long id) {
		Optional<Email> email = Optional.ofNullable(emailRepository.getById(id));
		if (email.isPresent()) {
			return email.get();
		}

		else {

			throw new ResourceNotFound("Employee", "Id", id);
		}
	}

	@Override
	public Email updateEmail(Email email, long id) {
		Email newEmail = new Email();
		try {
			newEmail = emailRepository.findById(id).orElseThrow();
		} catch (Exception e) {
			e.printStackTrace();
		}

		newEmail.setSubject(email.getSubject());
		newEmail.setBody(email.getBody());

		emailRepository.save(newEmail);
		return newEmail;
	}

	@Override
	public List<Email> getEmailBySubject(String subject) {
		return emailRepository.findBySubject(subject);
	}

	@Override
	public void deleteEmail(long id) {
		emailRepository.deleteById(id);
	}

	@Override
	public List<Email> getEmailsBySenderId(long user_id) {
		return emailRepository.findBySenderId(user_id);
	}
}
