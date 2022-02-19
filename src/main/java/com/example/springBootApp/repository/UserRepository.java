package com.example.springBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBootApp.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	List<User> findByFirstName(String firstName);

	List<User> findByLastName(String lastName);

	List<User> findByEmail(String email);

}

