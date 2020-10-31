package com.aspire.training.ms.session1.restexample.out.configuration;

import com.aspire.training.ms.session1.restexample.restsample.GreetingMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("qa")
public class QAConfigurationClass {

    @Bean("qaGreetingMessage")
    public GreetingMessage devGreetingMessage(){

        return new GreetingMessage("QA");
    }
}
