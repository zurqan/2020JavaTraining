package com.aspire.training.accountenentsourcing.common.event;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
public class AmountDeposited {

    private String accountId;

    private double amount;
}
