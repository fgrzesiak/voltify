package com.example.lager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LagerApplication {
    public static void main(String[] args) {
  
    	
    String urlSpring = System.getenv("SPRING_DATASOURCE_URL");
	
	if (urlSpring == null) urlSpring = "jdbc:mysql://localhost:3308/lager";
    
	String urlRabbit = System.getenv("SPRING_QUEUE_URL");
	if (urlRabbit == null) urlRabbit = "localhost";
    
    System.out.println("#############SPRING_DATASOURCE_URL##############" + urlSpring);
	System.out.println("###############SPRING_QUEUE_URL#################" + urlRabbit);
    
	System.setProperty("spring.datasource.url",urlSpring);    	
	System.setProperty("spring.rabbitmq.host",urlRabbit);    	

	
    SpringApplication.run(LagerApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
    
	 
}

