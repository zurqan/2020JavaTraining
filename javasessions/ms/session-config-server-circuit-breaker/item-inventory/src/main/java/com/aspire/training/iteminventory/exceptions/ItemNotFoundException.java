package com.aspire.training.iteminventory.exceptions;

public class ItemNotFoundException extends AbstractTrainingException {

    private final String itemId;

    public ItemNotFoundException(String itemId) {
        super(itemId);
        this.itemId = itemId;
    }
}
