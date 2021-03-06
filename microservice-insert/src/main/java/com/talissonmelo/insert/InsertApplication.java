package com.talissonmelo.insert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class InsertApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsertApplication.class, args);
	}

}
