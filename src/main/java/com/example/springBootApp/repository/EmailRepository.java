package com.example.springBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springBootApp.entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{

	List<Email> findBySubject(String subject);

}
