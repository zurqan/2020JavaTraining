package com.aspire.training.es.cartservice.common.event;

import lombok.Value;

@Value
public class ItemRemovedFromCart {

    private String cartId;

    private String itemId;

}
