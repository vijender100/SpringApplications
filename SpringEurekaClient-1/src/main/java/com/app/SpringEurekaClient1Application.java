package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClient1Application.class, args);
	}

}
