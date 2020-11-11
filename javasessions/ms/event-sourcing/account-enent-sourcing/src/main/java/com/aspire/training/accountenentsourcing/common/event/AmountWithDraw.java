package com.aspire.training.accountenentsourcing.common.event;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AmountWithDraw {

    private String accountId;

    private double amount;
}
