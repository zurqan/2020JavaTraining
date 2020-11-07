package com.aspire.training.usermanga.adapter.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String,User> users=new HashMap(){{
       put("1",new User("1","Mohammad",20,GENDER.MALE));
       put("2",new User("2","Ahmad",33,GENDER.MALE));
       put("3",new User("3","Rana",25,GENDER.FEMALE));
    }};

    @GetMapping("/{userId}")
    public User gettingUser(@PathVariable("userId") String userId){

        return users
                .get(userId);
    }
}
