package com.aspire.training.es.cartservice.common.event;

import lombok.Value;

@Value
public class ItemAddedToCartEvent {

    private String cartId;

    private String itemId;

    private double price;

}
