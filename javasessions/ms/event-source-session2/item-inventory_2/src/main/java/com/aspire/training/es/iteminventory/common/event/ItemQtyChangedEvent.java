package com.aspire.training.es.iteminventory.common.event;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ItemQtyChangedEvent {

    private String itemNo;
    private int oldQty;
    private int newQty;
}
