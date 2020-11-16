package com.aspire.training.es.iteminventory.adapter.repository;

import com.aspire.training.es.iteminventory.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    public void addItem(Item item);

    public void updateQty(String itemNo,int qty);

    public void incrementCount();

    Optional<Item> loadItemByNo(String itemNo);

    Integer totalItemCount();

    List<Item> loadAll();

//    public void upda
}
