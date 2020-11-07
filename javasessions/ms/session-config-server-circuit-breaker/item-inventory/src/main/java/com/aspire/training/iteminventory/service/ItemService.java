package com.aspire.training.iteminventory.service;


import com.aspire.training.iteminventory.model.Item;
import com.aspire.training.iteminventory.model.Price;
import com.aspire.training.iteminventory.repository.ItemRepository;

import java.util.Optional;

public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item){
         itemRepository.addItem(item);
    }

    public boolean updateItem(Item item){
        return itemRepository.updateItem(item);
    }

    public void updatePrice(String itemId,int newPrice){
        itemRepository
                .loadItem(itemId)
                .map(item->item
                        .toBuilder()
                        .price( new Price(newPrice))
                        .build())
                .ifPresent(itemRepository::updateItem);

    }

    public void applyDiscount(String itemId, int discount){

        itemRepository
                .loadItem(itemId)
                .map(item->item
                        .toBuilder()
                        .price( new Price(item.getPrice().getValue()*discount/100))
                        .build())
                .ifPresent(itemRepository::updateItem);


    }

    public Optional<Item> loadItem(String itemId){

        return itemRepository.loadItem(itemId);
    }
}
