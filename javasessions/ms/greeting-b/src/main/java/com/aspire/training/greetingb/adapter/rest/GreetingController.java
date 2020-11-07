package com.aspire.training.greetingb.adapter.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final RestTemplate restTemplate;

    public GreetingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{userId}")
    public String greeting(@PathVariable("userId") String userId){

        // call service A to get the user information

        Caller caller = restTemplate.getForObject("http://user-managemnt-a/users/"+userId, Caller.class);

        System.out.println("caller = " + caller);
        //then prepare a greeting message and return it

        return "Hello "+((caller.getGender()==GENDER.MALE)?"Mr. ":"Ms. ")+caller.getName();
    }
}
