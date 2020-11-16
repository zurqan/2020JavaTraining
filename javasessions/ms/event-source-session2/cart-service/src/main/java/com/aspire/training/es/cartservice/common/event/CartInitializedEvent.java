package com.aspire.training.es.cartservice.common.event;

import lombok.Value;

@Value
public class CartInitializedEvent {
    private String cartId;

    private String customerId;

}
