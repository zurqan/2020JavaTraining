package com.aspire.training.iteminventory.model;

import lombok.Value;

@Value
public class Price {

    private final int value;

    public  Price withQty(int qty){
        return new Price(value * qty);
    }

    public Price withDiscount(int discount){
        return new Price(value * discount / 100);
    }
}
