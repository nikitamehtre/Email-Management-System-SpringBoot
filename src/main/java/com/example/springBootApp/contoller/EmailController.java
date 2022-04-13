package com.example.springBootApp.contoller;

import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.parser.MediaType;
import org.hibernate.mapping.Set;
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
import com.example.springBootApp.entity.User;
import com.example.springBootApp.service.EmailService;
import com.example.springBootApp.service.UserService;

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
	
//	@GetMapping("/")
//	String index() {
//		return "index";
//	}

	@GetMapping
	public String getAllEmail(Model model) {
		List<Email> emails = emailService.getAllEmail();
		List<Email> sentEmails = emailService.getEmailsBySenderId(1);
		List<Email> receivedEmails = emailService.getEmailsByReceiverId(1);
		
		
		model.addAttribute("emails", emails);
		model.addAttribute("title", "All emails");
		model.addAttribute("count", emails.size());
		model.addAttribute("sentCount", sentEmails.size());
		model.addAttribute("receivedCount", receivedEmails.size());
		return "list-emails";
	}
	
	@GetMapping("/sent")
	public String getSentEmail(Model model) {
		List<Email> emails = emailService.getAllEmail();
		List<Email> sentEmails = emailService.getEmailsBySenderId(1);
		List<Email> receivedEmails = emailService.getEmailsByReceiverId(1);
		model.addAttribute("emails", sentEmails);
		model.addAttribute("title", "Sent emails");
		model.addAttribute("count", emails.size());
		model.addAttribute("sentCount", sentEmails.size());
		model.addAttribute("receivedCount", receivedEmails.size());
		return "list-emails";
	}
	
	@GetMapping("/received")
	public String getReceivedEmail(Model model) {
		List<Email> emails = emailService.getAllEmail();
		List<Email> sentEmails = emailService.getEmailsBySenderId(1);
		List<Email> receivedEmails = emailService.getEmailsByReceiverId(1);
		model.addAttribute("emails", receivedEmails);
		model.addAttribute("title", "Received emails");
		model.addAttribute("count", emails.size());
		model.addAttribute("sentCount", sentEmails.size());
		model.addAttribute("receivedCount", receivedEmails.size());

		return "list-emails";
	}
	
	@PostMapping("/send-email")
	public String postSendEmail(@RequestParam String emails, @RequestParam String subject, @RequestParam String body) {
		String[] emailsArray = emails.split(",");
		long sender_id = 1;
		
		User sender = emailService.getUserById(sender_id);
		java.util.Set<User> receivers = emailService.findByUserEmailIn(emailsArray);

		
		Email email = new Email();
		email.setSubject(subject);
		email.setBody(body);
		email.setSender(sender);
		email.setReceivers(receivers);
		email.setCreatedAt(new java.util.Date());
		
		emailService.saveEmail(email);
		return "redirect:/api/emails/sent";
	}
	
	@GetMapping("/send-email")
	public String getSendEmail(Model model) {
		return "send-email";
	}
	
	@GetMapping("{id}")
	public String getEmailById(@PathVariable long id, Model model) {
		Email email = emailService.getEmailById(id);
		model.addAttribute("email", email);

		return "show-email";
	}
	
	@GetMapping("/emailBySubject/{subject}")
	public List<Email> getEmailBySubject(@PathVariable("subject")String subject){
		return emailService.getEmailBySubject(subject);
	}
	
//	api/emails/sent?user_id=1
//	@GetMapping("/sent")
//	public List<Email> getSentEmails(@RequestParam long user_id){
//		return emailService.getEmailsBySenderId(user_id);
//	}
	
	

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
