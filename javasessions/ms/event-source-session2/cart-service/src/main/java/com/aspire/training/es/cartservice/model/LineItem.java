package com.aspire.training.es.cartservice.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class LineItem {

    private String itemId;

    private int qty;

    private double price;
}
