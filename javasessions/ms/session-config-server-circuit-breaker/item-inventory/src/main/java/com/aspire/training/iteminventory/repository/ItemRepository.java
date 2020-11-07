package com.aspire.training.iteminventory.repository;

import com.aspire.training.iteminventory.model.Item;

import java.util.Optional;

public interface ItemRepository {
    void addItem(Item item);

    boolean updateItem(Item item);

    Optional<Item> loadItem(String itemId);
}
