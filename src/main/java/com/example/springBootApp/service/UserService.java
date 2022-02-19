package com.example.springBootApp.service;

import java.util.List;

import com.example.springBootApp.entity.Email;
import com.example.springBootApp.entity.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUser();
	User getUserById(long id);
	User updateUser(User user, long id);
	List<User> getUserByFirstName(String firstName);
	List<User> getUserByLastName(String lastName);
	List<User> getUserByEmail(String email);
	void deleteuser(long id);

}
