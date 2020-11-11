package com.aspire.training.accountenentsourcing.common.event;

import com.aspire.training.accountenentsourcing.model.AccountType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AccountCreatedEvent {

    private String accountId;

    private String name;

    private AccountType accountType;

    private double balance;
}
