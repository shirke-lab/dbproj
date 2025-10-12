package com.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
	@EnableJpaRepositories(
	    basePackages = "com.example.repository.db1fordbproj",
	    entityManagerFactoryRef = "primaryEntityManagerFactory",
	    transactionManagerRef = "primaryTransactionManager"
	)
	public class Db1RepositoryConfig {
	    // You can leave this empty — it's just for wiring
	}


