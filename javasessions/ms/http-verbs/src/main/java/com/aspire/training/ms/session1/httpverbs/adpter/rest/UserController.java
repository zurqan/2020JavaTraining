package com.aspire.training.ms.session1.httpverbs.adpter.rest;

import com.aspire.training.ms.session1.httpverbs.model.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<String,User> users;

    public UserController() {
        this.users = new HashMap();
    }

    @PostMapping
    public User savingUser(@RequestBody @Valid User user){
        System.out.println("UserController.savingUser");
        if(users.get(user.getId())!=null){
            throw new RuntimeException("Already exist");
        }
        users.put(user.getId(),user);
        return user;
    }

    @GetMapping
    public Collection<User> allUsers(){
        return users.values();
    }

    @GetMapping("/{userId}") //users/5
    public User gettingSpecificUser(@PathVariable("userId") String userId){
        return users.get(userId);
    }

    @PutMapping("/{userId}")
    public void updatingUser(@RequestBody User user, @PathVariable("userId") String userId){
        users.computeIfPresent(userId,
                (k,v)->user);
    }
}
