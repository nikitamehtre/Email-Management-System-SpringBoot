package com.example.springBootApp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springBootApp.entity.User;
import com.example.springBootApp.exception.ResourceNotFound;
import com.example.springBootApp.repository.UserRepository;
import com.example.springBootApp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();

	}

	@Override
	public User getUserById(long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {

			throw new ResourceNotFound("user", "Id", id);
		}

	}

	@Override
	public User updateUser(User user, long id) {
		User newUser = new User();
		try {
			newUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("User", "Id", id));
		} catch (ResourceNotFound e) {

			e.printStackTrace();
		}
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setContactNumber(user.getContactNumber());
		newUser.setPassword(user.getPassword());

		userRepository.save(newUser);
		return newUser;
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}

	@Override
	public List<User> getUserByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
	}

	@Override
	public List<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void deleteuser(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User updateUserPartially(User user, long id) {
		User newUser = new User();
		try {
			 newUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("User", "Id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		if(user.getFirstName() != null) {
			newUser.setFirstName(user.getFirstName());
		}
		if(user.getLastName() != null) {
			newUser.setLastName(user.getLastName());
		}
		if(user.getEmail() != null) {
			newUser.setEmail(user.getEmail());
		}
		if(user.getContactNumber() != null) {
			newUser.setContactNumber(user.getContactNumber());
		}
		if(user.getPassword() != null) {
			newUser.setPassword(user.getPassword());
		}
		userRepository.save(newUser);
		return newUser;
	}
	
	
	
}
