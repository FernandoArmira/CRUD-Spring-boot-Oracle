package com.app.CRUDOracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudOracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOracleApplication.class, args);
		System.out.println("Server running on port 8080");
	}

}
