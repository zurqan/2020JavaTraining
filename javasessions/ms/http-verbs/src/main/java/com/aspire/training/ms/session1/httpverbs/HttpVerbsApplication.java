package com.aspire.training.ms.session1.httpverbs;

import com.aspire.training.ms.session1.httpverbs.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HttpVerbsApplication {

//	@Bean
//	public CommandLineRunner test(){
//		return args->{
//			User mohammad = new User("10", "Mohammad", 40);
//			System.out.println("mohammad = " + mohammad);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(HttpVerbsApplication.class, args);
	}

}
