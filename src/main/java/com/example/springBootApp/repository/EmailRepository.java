package com.example.springBootApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBootApp.entity.Email;

public interface EmailRepository extends JpaRepository<Email, String>{

}
