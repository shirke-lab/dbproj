package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example", exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
public class DbprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbprojApplication.class, args);
	}

}
