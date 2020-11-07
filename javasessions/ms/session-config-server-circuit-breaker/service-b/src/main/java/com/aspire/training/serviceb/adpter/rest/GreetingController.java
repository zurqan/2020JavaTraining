package com.aspire.training.serviceb.adpter.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping("{name}")
    public String greeting(@PathVariable("name") String name){
        return "Service -b says: Hello "+name;
    }

}
