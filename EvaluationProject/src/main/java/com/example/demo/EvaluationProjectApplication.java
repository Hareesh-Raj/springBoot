package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * @author Hareesh Raj Ramanathan
 * Here is the point were the spring project starts.
 * */
@SpringBootApplication(scanBasePackages = {
		"com.model","com.example.demo","com.controller","com.service"
})
@EnableJpaRepositories(basePackageClasses = com.model.UserDAO.class)
@EntityScan(basePackageClasses = com.model.UserDTO.class)
public class EvaluationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluationProjectApplication.class, args);

	}

}
