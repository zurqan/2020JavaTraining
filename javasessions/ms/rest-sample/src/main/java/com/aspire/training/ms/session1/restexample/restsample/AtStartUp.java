package com.aspire.training.ms.session1.restexample.restsample;

import org.springframework.boot.CommandLineRunner;

//@Component
public class AtStartUp implements CommandLineRunner {

    private final GreetingConfigurationProperties greetingConfigurationProperties;

    public AtStartUp(GreetingConfigurationProperties greetingConfigurationProperties) {
        this.greetingConfigurationProperties = greetingConfigurationProperties;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started!!!!");
        System.out.println("greetingConfigurationProperties.getGreeting() = " + greetingConfigurationProperties.getGreeting());
        System.out.println("greetingConfigurationProperties.isEnabled() = " + greetingConfigurationProperties.isEnabled());
    }
}
