package com.aspire.training.accountenentsourcing.model;

import com.aspire.training.accountenentsourcing.common.command.CreateAccountCommand;
import com.aspire.training.accountenentsourcing.common.command.DepositAmountCommand;
import com.aspire.training.accountenentsourcing.common.command.WithDrawCommand;
import com.aspire.training.accountenentsourcing.common.event.AccountCreatedEvent;
import com.aspire.training.accountenentsourcing.common.event.AmountDeposited;
import com.aspire.training.accountenentsourcing.common.event.AmountWithDraw;
import com.aspire.training.accountenentsourcing.exception.NoAvailableBalanceException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private String id;

    private double balance;

    private AccountType accountType;

    private String name;

    public AccountAggregate() {
    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand) {

        AccountCreatedEvent createdEv = AccountCreatedEvent
                .builder()
                .accountId(createAccountCommand.getAccountId())
                .accountType(createAccountCommand.getAccountType())
                .name(createAccountCommand.getName())
                .build();
        this.id=createAccountCommand.getAccountId();

        apply(createdEv);
    }

    @CommandHandler
    public void depositAmount(DepositAmountCommand depositAmountCommand){

        AmountDeposited amountDeposited = AmountDeposited
                .builder()
                .accountId(this.id)
                .amount(depositAmountCommand.getAmount())
                .build();

        apply(amountDeposited);

    }

    @CommandHandler
    public void withDraw(WithDrawCommand withDrawCommand){

        if(this.balance<withDrawCommand.getAmount()){
            throw new NoAvailableBalanceException();
        }
        AmountWithDraw amountWithDraw = AmountWithDraw
                .builder()
                .accountId(this.id)
                .amount(withDrawCommand.getAmount())
                .build();

        apply(amountWithDraw);

    }

    @EventSourcingHandler
    public void createdAccount(AccountCreatedEvent accountCreatedEvent){

        System.out.println("accountCreatedEvent = " + accountCreatedEvent);
        this.accountType=accountCreatedEvent.getAccountType();
        this.balance=accountCreatedEvent.getBalance();
        this.id=accountCreatedEvent.getAccountId();
        this.name=accountCreatedEvent.getName();
        System.out.println("this.balance = " + this.balance);
    }

    @EventSourcingHandler
    public void amountDeposited(AmountDeposited amountDeposited){
        System.out.println("amountDeposited = " + amountDeposited);
        this.balance+=amountDeposited.getAmount();
        System.out.println("this.balance = " + this.balance);

    }

    @EventSourcingHandler
    public void amountWithDraw(AmountWithDraw withDraw){
        System.out.println("withDraw = " + withDraw);
        this.balance-=withDraw.getAmount();
        System.out.println("this.balance = " + this.balance);

    }



}
