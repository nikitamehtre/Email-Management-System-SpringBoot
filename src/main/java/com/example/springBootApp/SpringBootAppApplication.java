package com.example.springBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.springBootApp"})
@EntityScan("com.example.springBootApp")
@EnableJpaRepositories("com.example.springBootApp")
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

}

