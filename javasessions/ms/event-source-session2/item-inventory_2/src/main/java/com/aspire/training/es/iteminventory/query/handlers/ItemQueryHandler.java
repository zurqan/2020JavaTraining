package com.aspire.training.es.iteminventory.query.handlers;

import com.aspire.training.es.iteminventory.adapter.repository.ItemRepository;
import com.aspire.training.es.iteminventory.common.query.FindItemByNoQuery;
import com.aspire.training.es.iteminventory.common.query.LoadAllItemsQuery;
import com.aspire.training.es.iteminventory.common.query.TotalItemCountQuery;
import com.aspire.training.es.iteminventory.model.Item;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemQueryHandler {

    private final ItemRepository itemRepository;

    public ItemQueryHandler(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @QueryHandler
    public Optional<Item> findItemByNo(FindItemByNoQuery findItemByNoQuery){

        return itemRepository.loadItemByNo(findItemByNoQuery.getItemNo());
    }

    @QueryHandler
    public Integer totalItemCount(TotalItemCountQuery totalItemCountQuery){

        return itemRepository.totalItemCount();
    }

    @QueryHandler
    public List<Item> loadAllItems(LoadAllItemsQuery loadAllItemsQuery){
        return itemRepository.loadAll();
    }
}
