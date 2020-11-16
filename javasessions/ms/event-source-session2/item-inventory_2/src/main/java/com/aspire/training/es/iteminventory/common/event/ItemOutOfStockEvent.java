package com.aspire.training.es.iteminventory.common.event;

import lombok.Value;

@Value
public class ItemOutOfStockEvent {
    private String itemNo;
}
