package com.co.pragma.serviceclientimageclean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceClientImageCleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceClientImageCleanApplication.class, args);
	}

}
