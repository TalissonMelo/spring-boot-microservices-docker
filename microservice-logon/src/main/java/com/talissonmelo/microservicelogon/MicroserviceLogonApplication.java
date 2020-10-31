package com.talissonmelo.microservicelogon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceLogonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceLogonApplication.class, args);
	}

}
