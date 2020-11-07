package com.aspire.training.usermanga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserManagementAApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementAApplication.class, args);
	}

}
