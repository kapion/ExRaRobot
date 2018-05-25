package ru.kapion.exrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ExrobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExrobotApplication.class, args);
	}
}
