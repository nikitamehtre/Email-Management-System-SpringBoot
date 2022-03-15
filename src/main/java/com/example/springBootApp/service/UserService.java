package com.example.springBootApp.service;

import java.util.List;
import com.example.springBootApp.entity.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUser();
	User getUserById(long id);
	User updateUser(User user, long id);
	List<User> getUserByFirstName(String firstName);
	List<User> getUserByLastName(String lastName);
	List<User> getUserByEmail(String email);
	List<User> getUserByFirstNameAndLastName(String firstName, String lastName);
	List<User> getUserByFirstNameOrLastName(String firstName, String lastName);
	void deleteuser(long id);
	User updateUserPartially(User user, long id);
	List<User> getUsersByFirstName(String firstName);
	List<User> getUsersByFirstNameAndLastName(String firstName, String lastName);
	List<User> importUsers(List<User> users);

}
