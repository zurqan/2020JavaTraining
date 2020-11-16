package com.aspire.training.es.iteminventory.event.handlers2;

import com.aspire.training.es.iteminventory.adapter.repository.ItemRepository;
import com.aspire.training.es.iteminventory.common.event.ItemCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class ItemCountInSystemHandler {

    private final ItemRepository itemRepository;

    public ItemCountInSystemHandler(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;

    }

    @EventHandler
    public void itemCreated(ItemCreatedEvent itemCreatedEvent){

        itemRepository.incrementCount();
    }
}
