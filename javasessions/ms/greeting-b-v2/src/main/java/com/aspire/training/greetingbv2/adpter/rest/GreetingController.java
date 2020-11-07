package com.aspire.training.greetingbv2.adpter.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Value("${server.port}")
    private String serverPort;

    private final UMServiceInterface umServiceInterface;

    public GreetingController(UMServiceInterface umServiceInterface) {
        this.umServiceInterface = umServiceInterface;
    }

    @GetMapping("/{userId}")
    public String greeting(@PathVariable("userId") String userId){

        Caller caller = umServiceInterface.requestingUser(userId);

        System.out.println("caller = " + caller);

        //then prepare a greeting message and return it

        return caller == Caller.EMPTY?"Hello!!":serverPort+" - Hello "+((caller.getGender()==GENDER.MALE)?"Mr. ":"Ms. ")+caller.getName();

    }
}
