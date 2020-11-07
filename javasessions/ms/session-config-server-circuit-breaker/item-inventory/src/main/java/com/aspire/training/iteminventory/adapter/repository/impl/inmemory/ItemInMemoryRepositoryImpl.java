package com.aspire.training.iteminventory.adapter.repository.impl.inmemory;

import com.aspire.training.iteminventory.model.Item;
import com.aspire.training.iteminventory.repository.ItemRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemInMemoryRepositoryImpl implements ItemRepository {

    private Map<String,Item> db=new HashMap<>();

    @Override
    public void addItem(Item item) {
        db.put(item.getItemId(),item);
    }

    @Override
    public boolean updateItem(Item item) {
        if(db.get(item.getItemId())==null){
            return false;
        }
        db.put(item.getItemId(),item);
        return false;
    }

    @Override
    public Optional<Item> loadItem(String itemId) {

        Item item = db.get(itemId);
        return Optional.ofNullable(item);
    }
}
