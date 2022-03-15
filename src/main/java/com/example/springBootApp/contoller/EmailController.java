package com.example.springBootApp.contoller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootApp.entity.Email;
import com.example.springBootApp.service.EmailService;

@Controller
@RequestMapping("/api/emails")
public class EmailController {
	private EmailService emailService;

	public EmailController(EmailService emailService) {
		super();
		this.emailService = emailService;
	}

	@PostMapping
	public ResponseEntity<Email> saveEmail(@RequestBody Email email) {
		return new ResponseEntity<Email>(emailService.saveEmail(email), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	String index() {
		return "index";
	}

	@GetMapping
	public String getAllEmail(Model model) {
		List<Email> emails = emailService.getAllEmail();
		model.addAttribute("emails", emails);
		return "list-emails";
	}

	@GetMapping("{id}")
	public ResponseEntity<Email> getEmailById(@PathVariable long id) {
		return new ResponseEntity<Email>(emailService.getEmailById(id), HttpStatus.OK);
	}
	
	@GetMapping("/emailBySubject/{subject}")
	public List<Email> getEmailBySubject(@PathVariable("subject")String subject){
		return emailService.getEmailBySubject(subject);
	}
	
//	api/emails/sent?user_id=1
	@GetMapping("/sent")
	public List<Email> getSentEmails(@RequestParam long user_id){
		return emailService.getEmailsBySenderId(user_id);
	}
	
	

	@PutMapping("{id}")
	public ResponseEntity<Email> updateEmail(@PathVariable("id") long id, @RequestBody Email email) {

		return new ResponseEntity<Email>(emailService.updateEmail(email, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmail(@PathVariable("id") long id){
		emailService.deleteEmail(id);
		return new ResponseEntity<String>("Email record deleted", HttpStatus.OK);
	}	

}
