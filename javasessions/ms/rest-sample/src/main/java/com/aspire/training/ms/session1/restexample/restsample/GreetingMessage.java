package com.aspire.training.ms.session1.restexample.restsample;

import org.springframework.beans.factory.annotation.Value;

//@Component
public class GreetingMessage {

    private final String env;

    @Value("${com.aspire.training.greeting:'مرحبا'}")
    private String greetingMessage;

    public GreetingMessage(String env) {
        this.env = env;
    }


    public String sayHello(String name){
        return greetingMessage+" "+name+" -- "+env;
    }
}
