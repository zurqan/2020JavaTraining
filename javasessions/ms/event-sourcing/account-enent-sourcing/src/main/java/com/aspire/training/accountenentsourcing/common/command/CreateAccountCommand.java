package com.aspire.training.accountenentsourcing.common.command;

import com.aspire.training.accountenentsourcing.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountCommand {

    @TargetAggregateIdentifier
    private String accountId;

    private String name;

    private AccountType accountType;
}
