package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class StarterProjectApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx= SpringApplication.run(StarterProjectApplication.class, args);
//		StudentInterfaceImpl studentImpl =  ctx.getBean("ss",StudentInterfaceImpl.class);
//		StudentDTO dto = new StudentDTO();
//		dto.setId(100);
//		dto.setName("Hareesh");
//		dto.setCity("karur");
//		studentImpl.createStudent(dto);
	}

}
