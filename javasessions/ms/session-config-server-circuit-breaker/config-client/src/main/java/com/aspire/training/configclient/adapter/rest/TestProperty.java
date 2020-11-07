package com.aspire.training.configclient.adapter.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
@RefreshScope
public class TestProperty {

    @Value("${com.training.tax}")
    private int tax;

    @GetMapping
    public String gettingValue(){
        return String.format("Tax is %d", tax);
    }
}
