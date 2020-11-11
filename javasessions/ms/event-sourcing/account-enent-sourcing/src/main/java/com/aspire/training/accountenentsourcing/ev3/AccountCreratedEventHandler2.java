package com.aspire.training.accountenentsourcing.ev3;

import com.aspire.training.accountenentsourcing.common.event.AccountCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class AccountCreratedEventHandler2 {

    @EventHandler
    public void createdAccount(AccountCreatedEvent accountCreatedEvent){
        //send thanks for joining email
        String msg = String.format("Thanks for joining %s", accountCreatedEvent.getName());

        System.out.println("msg = " + msg);
    }
}
