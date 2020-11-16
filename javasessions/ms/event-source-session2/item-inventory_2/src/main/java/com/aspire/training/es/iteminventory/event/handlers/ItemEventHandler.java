package com.aspire.training.es.iteminventory.event.handlers;

import com.aspire.training.es.iteminventory.adapter.repository.ItemRepository;
import com.aspire.training.es.iteminventory.common.event.ItemCreatedEvent;
import com.aspire.training.es.iteminventory.common.event.ItemQtyChangedEvent;
import com.aspire.training.es.iteminventory.model.Item;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class ItemEventHandler {

    private final ItemRepository itemRepository;

    public ItemEventHandler(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @EventHandler
    public void itemCreated(ItemCreatedEvent itemCreatedEvent){

        System.out.println("Item created - event-handler");
        //save to DB for future query

        Item item = Item
                .builder()
                .itemNo(itemCreatedEvent.getItemNo())
                .qty(itemCreatedEvent.getQty())
                .desc(itemCreatedEvent.getDesc())
                .imgLinks(itemCreatedEvent.getImgLinks())
                .manId(itemCreatedEvent.getManId())
                .price(itemCreatedEvent.getPrice())
                .build();

        itemRepository.addItem(item);
    }

    @EventHandler
    public void itemQtyChanged(ItemQtyChangedEvent itemQtyChangedEvent){

        //update item qty
        itemRepository.updateQty(itemQtyChangedEvent.getItemNo(),
                itemQtyChangedEvent.getNewQty());
    }
}
