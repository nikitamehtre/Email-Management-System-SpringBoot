package com.example.springBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springBootApp.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	List<User> findByFirstName(String firstName);

	List<User> findByLastName(String lastName);

	List<User> findByEmail(String email);

	List<User> findByFirstNameAndLastName(String firstName, String lastName);

	List<User> findByFirstNameOrLastName(String firstName, String lastName);
	
	@Query("select e from User e where firstName = :name")
	List<User> findUsersByFirstName1(@Param("name") String firstName);
	
	@Query("select e from User e where e.firstName = :firstName and e.lastName = :lastName")
	List<User> findUsersByFirstNameAndlastName(@Param("firstName") String firstName, @Param("lastName") String lastName);


	List<User> findUsersByFirstName(String firstName);



}

