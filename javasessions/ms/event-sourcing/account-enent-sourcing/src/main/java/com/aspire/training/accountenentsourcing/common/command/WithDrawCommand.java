package com.aspire.training.accountenentsourcing.common.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WithDrawCommand {
    @TargetAggregateIdentifier
    private String accountId;

    private double amount;

}
