package com.aspire.training.greetingbv2.adpter.rest;

import org.springframework.stereotype.Component;

@Component
public class UMServiceAFallImpl implements UMServiceInterface{
    @Override
    public Caller requestingUser(String userId) {
        return Caller.EMPTY;
    }
}
