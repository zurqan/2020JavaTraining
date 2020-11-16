package com.aspire.training.es.iteminventory.common.event;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ItemCreatedEvent {
    private String itemNo;
    private String desc;
    private List<String> imgLinks;
    private double price;
    private int qty;
    private String manId;

}
