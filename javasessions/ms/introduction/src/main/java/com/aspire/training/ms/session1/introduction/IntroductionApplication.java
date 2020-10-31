package com.aspire.training.ms.session1.introduction;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class IntroductionApplication {

	@Value("${greeting:'مرحبا'}")
	private String greeting;

	@Bean
	public CommandLineRunner printEnv(Environment environment){

		return args -> {
			System.out.println(greeting);

			System.out.println("environment.getProperty(\"greeting\") = " + environment.getProperty("greeting"));
			System.out.println("My Command Line Runner was Called");
		};
	}

	@Bean
	public CommandLineRunner testInjection(SampleComponent sampleComponent){
		return args->{
			System.out.println("sampleComponent = " + sampleComponent.getGreetingMessage());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(IntroductionApplication.class, args);
	}

}
