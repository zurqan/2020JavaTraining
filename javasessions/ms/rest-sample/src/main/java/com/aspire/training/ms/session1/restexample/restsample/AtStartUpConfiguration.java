package com.aspire.training.ms.session1.restexample.restsample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtStartUpConfiguration {

    @Bean
    public AtStartUp createStartUp(GreetingConfigurationProperties greetingConfigurationProperties){
        return new AtStartUp(greetingConfigurationProperties);
    }
}
