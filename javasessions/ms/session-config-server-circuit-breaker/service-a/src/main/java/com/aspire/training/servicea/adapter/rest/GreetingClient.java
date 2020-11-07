package com.aspire.training.servicea.adapter.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting-client")
public class GreetingClient {

    private final ServiceBClient serviceBClient;

    public GreetingClient(ServiceBClient serviceBClient) {
        this.serviceBClient = serviceBClient;
    }

    @GetMapping("/{name}")
    @HystrixCommand(fallbackMethod = "defaultGreeting")
    public String greeting(@PathVariable("name")String name){
        return " A-> "+serviceBClient.greeting(name);
    }

    public String defaultGreeting(String name){
        return "Hello "+name;
    }
}
