package com.jaktyInfoTech.hibernateMysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class HibernateMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateMysqlApplication.class, args);
	}

}
