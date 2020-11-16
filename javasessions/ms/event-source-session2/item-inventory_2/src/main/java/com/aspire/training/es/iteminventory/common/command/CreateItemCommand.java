package com.aspire.training.es.iteminventory.common.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemCommand {

    @TargetAggregateIdentifier
    private String itemNo;

    private String desc;
    private List<String> imgLinks;
    private double price;
    private int qty;
    private String manId;

}
