package com.aspire.training.es.cartservice.common.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddItemToCartCommand {
    @TargetAggregateIdentifier
    private String cartId;

    private String itemNo;

    private double price;
}
