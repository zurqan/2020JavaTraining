package com.aspire.training.es.iteminventory.model;

import com.aspire.training.es.iteminventory.common.command.CreateItemCommand;
import com.aspire.training.es.iteminventory.common.command.IncreaseItemQtyCommand;
import com.aspire.training.es.iteminventory.common.command.ReduceItemQtyCommand;
import com.aspire.training.es.iteminventory.common.event.ItemCreatedEvent;
import com.aspire.training.es.iteminventory.common.event.ItemOutOfStockEvent;
import com.aspire.training.es.iteminventory.common.event.ItemQtyChangedEvent;
import com.aspire.training.es.iteminventory.exception.NoAvailableItemQtyException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.ApplyMore;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class ItemAggregate {

    @AggregateIdentifier
    private String itemNo;

    private Item item;

    public ItemAggregate() {
    }

    @CommandHandler
    public ItemAggregate(CreateItemCommand createItemCommand) {

        ItemCreatedEvent itemCreatedEvent = ItemCreatedEvent
                .builder()
                .itemNo(createItemCommand.getItemNo())
                .desc(createItemCommand.getDesc())
                .imgLinks(createItemCommand.getImgLinks())
                .manId(createItemCommand.getManId())
                .price(createItemCommand.getPrice())
                .qty(createItemCommand.getQty())
                .build();

        apply(itemCreatedEvent);
    }


    @CommandHandler
    public void increasingItemQty(IncreaseItemQtyCommand increaseItemQtyCommand) {

        ItemQtyChangedEvent itemQtyChangedEvent = ItemQtyChangedEvent
                .builder()
                .itemNo(this.itemNo)
                .oldQty(this.item.getQty())
                .newQty(this.item.getQty() + increaseItemQtyCommand.getAmount())
                .build();

        apply(itemQtyChangedEvent);
    }

    @CommandHandler
    public void reducingItemQty(ReduceItemQtyCommand reduceItemQtyCommand) {
        //TODO
        //Validate QTY
        if(item.getQty() < reduceItemQtyCommand.getAmount()){
            throw new NoAvailableItemQtyException(this.itemNo,item.getQty(),reduceItemQtyCommand.getAmount());
        }

        boolean noItemLeft =
                (this.item.getQty()-reduceItemQtyCommand.getAmount())==0;
        //ItemChanged  qty event
        ItemQtyChangedEvent itemQtyChangedEvent = ItemQtyChangedEvent
                .builder()
                .itemNo(this.itemNo)
                .oldQty(this.item.getQty())
                .newQty(this.item.getQty() - reduceItemQtyCommand.getAmount())
                .build();

        ApplyMore applyMore = apply(itemQtyChangedEvent);

        //Check if no item Left -> Item out of stock
        if(noItemLeft){
            applyMore.andThenApply(()->new ItemOutOfStockEvent(this.itemNo));
        }
    }

    @EventSourcingHandler
    public void itemCreated(ItemCreatedEvent itemCreatedEvent) {

        this.item =
                Item
                        .builder()
                        .itemNo(itemCreatedEvent.getItemNo())
                        .desc(itemCreatedEvent.getDesc())
                        .imgLinks(itemCreatedEvent.getImgLinks())
                        .manId(itemCreatedEvent.getManId())
                        .price(itemCreatedEvent.getPrice())
                        .qty(itemCreatedEvent.getQty())
                        .build();

        this.itemNo=itemCreatedEvent.getItemNo();

        System.out.println("itemCreatedEvent = [" + itemCreatedEvent + "]");
        System.out.println("item = " + item);
    }

    @EventSourcingHandler
    public void itemQtyChanged(ItemQtyChangedEvent itemQtyChangedEvent) {
        this.item =
                this.item
                        .toBuilder()
                        .qty(itemQtyChangedEvent.getNewQty())
                        .build();

        System.out.println("itemQtyChangedEvent = [" + itemQtyChangedEvent + "]");
        System.out.println("item = " + item);
    }
}
