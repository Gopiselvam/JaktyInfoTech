package com.jaktyInfoTech.springbootloggingsl4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/jacktyInfoTech/loggingSl4j")
public class SpringBootLoggingSl4jApplication {
	
	Logger log = LoggerFactory.getLogger(SpringBootLoggingSl4jApplication.class);
	
	@GetMapping("/greetings/{name}")
	public String greeting(@PathVariable String name) {
		log.debug("name received {} ",name);
		String response = "Hi" + name + "; Welcome to JaktyInfoTech";
		
		log.debug("response message {}", response);
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggingSl4jApplication.class, args);
	}

}
