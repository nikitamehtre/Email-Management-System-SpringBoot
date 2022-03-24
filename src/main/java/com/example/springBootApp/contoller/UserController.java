package com.example.springBootApp.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootApp.entity.Email;
import com.example.springBootApp.entity.User;
import com.example.springBootApp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@PostMapping("/import")
	public List<User> importUsers(@RequestBody List<User> users){
		return userService.importUsers(users);
	}
	
	@GetMapping("/")
	String index() {
		return "index";
	}
	
	@GetMapping
	public String getAllUser(Model model) {
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users);
		return "list-users";
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User>getUserById(@PathVariable("id") long id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@GetMapping("/userByFirstName/{firstName}")
	public List<User> getUserByFirstName(@PathVariable("firstName")String firstName){
		return userService.getUserByFirstName(firstName);
	}
	
	@GetMapping("/userByLastName/{lastName}")
	public List<User> getUserByLastName(@PathVariable("lastName")String lastName){
		return userService.getUserByLastName(lastName);
	}
	
	@GetMapping("/userByEmail/{email}")
	public Optional<User> getUserByEmail(@PathVariable("email")String email){
		return userService.getUserByEmail(email);
	}
	
	@GetMapping("/userByFirstNameAndLastName")
	public List<User> getUserByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
		return userService.getUserByFirstNameAndLastName(firstName, lastName);
	}
	
	@GetMapping("/userByFirstNameOrLastName")
	public List<User> getUserByFirstNameOrLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
		return userService.getUserByFirstNameOrLastName(firstName, lastName);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		
		return new ResponseEntity<User>(userService.updateUser(user, id),HttpStatus.OK);
	}	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
		userService.deleteuser(id);
		return new ResponseEntity<String>("User record deleted", HttpStatus.OK);
	}	
	
	@PatchMapping("{id}")
	public ResponseEntity<User>updateUserPartially(@PathVariable("id") long id, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUserPartially(user, id), HttpStatus.OK);
	}
	

}
