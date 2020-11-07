package com.aspire.training.greetingbv2.adpter.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="user-managemnt-a",fallback = UMServiceAFallImpl.class)
@Component
public interface UMServiceInterface {


    @GetMapping("/users/{userId}")
    public Caller requestingUser(@PathVariable("userId") String userId);

}
