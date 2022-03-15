package com.example.springBootApp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springBootApp.entity.Email;
import com.example.springBootApp.entity.User;
import com.example.springBootApp.service.EmailService;
import com.example.springBootApp.service.UserService;

@Controller
public class UIController {

	private EmailService emailService;
	private UserService userService;

	@Autowired	
	public UIController(EmailService emailService, UserService userService) {
		super();
		this.emailService = emailService;
		this.userService = userService;
	}

	@GetMapping("/")

	String index() {
		return "index";/// index.html
	}

	@GetMapping("/registration")
	public String userRegistrationForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "add-user";
	}

	@PostMapping("/saveUser")
	public String saveUser(@Valid  User user, Errors errors, Model model) {
		if(null != errors && errors.getErrorCount() > 0)
			return "redirect:/";
		else {
			userService.saveUser(user);
			List<User> users =  userService.getAllUser();
			model.addAttribute("successMessage", "Details are saved successfully");
		}
		return "redirect:/getUser";

	}

	@GetMapping("/getUsers")
	public String getAllUser(Model model) {

		List<User> users =  userService.getAllUser();

		model.addAttribute("users",users);

		return "list-user";
		}


/*	@GetMapping("/deptRegister")
	public String deptRegistrationForm(Model model) {
		Department department = new Department();
		model.addAttribute("department", department);
	    return "add-dept";
	}
*/
	@PostMapping("/saveEmail")
	public String addEmail(@Valid Email email, Errors errors, Model model) {
		if(null != errors && errors.getErrorCount() > 0)
			return "add-email";
		else {
	    emailService.saveEmail(email);
	    model.addAttribute("successMessage", "Details are saved successfully");
		}
	    return "list-email";
	}
	    @GetMapping("/getEmails")
	    public String getAllDepartment(Model model) {
	    	
	    	List<Email> emails =  emailService.getAllEmail();
	    	
	    	model.addAttribute("emails", emails);
	    	
	        return "list-emails";
	        }
	    
	}


