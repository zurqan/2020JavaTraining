package com.aspire.training.ms.session1.restexample.out.configuration;

import com.aspire.training.ms.session1.restexample.restsample.GreetingMessage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
//@ConditionalOnProperty(prefix = "com.aspire.training",name = "enabled"
//,matchIfMissing = true)
public class DevConfigurationClass {

    @Bean
    public GreetingMessage devGreetingMessage(){

        return new GreetingMessage("Dev");
    }
}
