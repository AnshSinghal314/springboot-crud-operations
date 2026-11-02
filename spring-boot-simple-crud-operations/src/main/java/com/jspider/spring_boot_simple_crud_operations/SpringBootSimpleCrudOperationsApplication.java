package com.jspider.spring_boot_simple_crud_operations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootSimpleCrudOperationsApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootSimpleCrudOperationsApplication.class, args);
		
		Environment environment = applicationContext.getEnvironment();
		
		String port = environment.getProperty("server.port");
		
		System.out.println("Port number is: "+ port);
		
	}
 
}
	