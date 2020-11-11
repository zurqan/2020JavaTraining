package com.aspire.training.accountenentsourcing.eventHandler;

import com.aspire.training.accountenentsourcing.common.event.AccountCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CreatedAccountHandler {

    //DONT Do that in production
    private AtomicInteger atomicInteger=new AtomicInteger();

    @EventHandler
    public void createdAccount(AccountCreatedEvent accountCreatedEvent){

        //I will increment # of accounts and save it in DB

        int count = atomicInteger.incrementAndGet();//Not in production

        System.out.println("count = " + count);

    }
}
