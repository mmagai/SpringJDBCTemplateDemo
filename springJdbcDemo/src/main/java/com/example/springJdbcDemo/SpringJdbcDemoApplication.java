package com.example.springJdbcDemo;

import com.example.springJdbcDemo.model.Employee;
import com.example.springJdbcDemo.repo.PostRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringJdbcDemoApplication.class, args);


		Employee employee = new Employee();
		employee.setId(3);
		employee.setFirstName("Channaveer");
		employee.setLastName("Magai");


		PostRepo postRepo = applicationContext.getBean(PostRepo.class);
		postRepo.save(employee);
        System.out.println(postRepo.findAll());



	}

}
