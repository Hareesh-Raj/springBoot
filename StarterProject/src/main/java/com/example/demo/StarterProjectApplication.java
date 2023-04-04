package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.model.InsufficientBalance;
import com.model.TransactionService;
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com"})
public class StarterProjectApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx =  SpringApplication.run(StarterProjectApplication.class, args);
		TransactionService service = ctx.getBean("tss",TransactionService.class);
		try {
			service.moneyTransfer(100,200, 500);
		} catch (InsufficientBalance e) {
			e.printStackTrace();
		}
	}

}
