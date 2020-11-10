package com.aspire.training.serviceamsgproducer.adapter.rest;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class HelloMessage {
    private String msg;
    private String userName;
    private String id;
}
