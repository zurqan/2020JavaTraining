package com.aspire.training.servicea.adapter.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-b")
public interface ServiceBClient {

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable("name") String name);
}
