package com.jaktyInfoTech.springbootjobSheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootJobShedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJobShedulerApplication.class, args);
	}

}
