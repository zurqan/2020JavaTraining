package com.aspire.training.es.iteminventory.exception;

import lombok.Value;

@Value
public class NoAvailableItemQtyException extends AbstractTrainingException {

    private final String itemNo;
    private int qty;
    private int amount;

    public NoAvailableItemQtyException(String itemNo, int qty, int amount) {
        this.itemNo = itemNo;
        this.qty = qty;
        this.amount = amount;
    }
}
