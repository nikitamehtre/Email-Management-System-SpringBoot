package com.example.springBootApp.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

	@GetMapping("/login")
	public String Login() {
		return "login";
	}

	@PostMapping("/login-submit")
	public String submitLogin(@RequestParam String email, @RequestParam String password) {
		System.out.println(email + password);
		return "login";
	}

	@GetMapping("/register")
	public String Register() {
		return "register";
	}

	@PostMapping("/register-submit")
	public String submitRegister(@RequestParam String name) {
		System.out.println(name);
		return "register";
	}



}
