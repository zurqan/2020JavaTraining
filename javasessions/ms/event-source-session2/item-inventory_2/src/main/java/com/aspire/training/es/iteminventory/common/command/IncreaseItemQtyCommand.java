package com.aspire.training.es.iteminventory.common.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncreaseItemQtyCommand {

    @TargetAggregateIdentifier
    private String itemNo;
    private int amount;
}
