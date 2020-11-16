package com.aspire.training.es.cartservice.model;

import com.aspire.training.es.cartservice.common.command.AddItemToCartCommand;
import com.aspire.training.es.cartservice.common.command.ClearCartCommand;
import com.aspire.training.es.cartservice.common.command.OpenCartCommand;
import com.aspire.training.es.cartservice.common.command.RemoveItemFromCartCommand;
import com.aspire.training.es.cartservice.common.event.CartInitializedEvent;
import com.aspire.training.es.cartservice.common.event.ItemAddedToCartEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.HashMap;
import java.util.Map;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class CartAggregate {

    @AggregateIdentifier
    private String cartId;

    private Map<String,LineItem> items;

    @CommandHandler
    public CartAggregate(OpenCartCommand openCartCommand){
        CartInitializedEvent cartInitializedEvent = new CartInitializedEvent(openCartCommand.getCartId(), openCartCommand.getCustomerId());

        apply(cartInitializedEvent);
    }

    @CommandHandler
    public void addingItem(AddItemToCartCommand addItemToCartCommand){

        ItemAddedToCartEvent itemAddedToCartEvent = new ItemAddedToCartEvent(
                addItemToCartCommand.getCartId(),
                addItemToCartCommand.getItemNo(),
                addItemToCartCommand.getPrice());
        apply(itemAddedToCartEvent);

    }

    @CommandHandler
    public void removingItem(RemoveItemFromCartCommand removeItemFromCartCommand){
        //TODO
    }
    @CommandHandler
    public void flushingCartt(ClearCartCommand clearCartCommand){
        //TODO
    }


    @EventSourcingHandler
    public void cartInitialized(CartInitializedEvent cartInitializedEvent){
        this.cartId=cartInitializedEvent.getCartId();
        this.items=new HashMap<>();
    }

}
