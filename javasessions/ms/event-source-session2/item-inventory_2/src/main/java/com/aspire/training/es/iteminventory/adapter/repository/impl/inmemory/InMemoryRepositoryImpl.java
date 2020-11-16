package com.aspire.training.es.iteminventory.adapter.repository.impl.inmemory;

import com.aspire.training.es.iteminventory.adapter.repository.ItemRepository;
import com.aspire.training.es.iteminventory.model.Item;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryRepositoryImpl implements ItemRepository {

    Map<String, Item> inMemoryRepo = new HashMap<>();

    private final AtomicInteger totalItemCount = new AtomicInteger();

    @Override
    public void addItem(Item item) {
        inMemoryRepo.put(item.getItemNo(), item);

        System.out.println("inMemoryRepo = " + inMemoryRepo);
    }

    @Override
    public void updateQty(String itemNo, int qty) {

        inMemoryRepo
                .compute(itemNo,
                        (key, value) ->
                                value
                                        .toBuilder()
                                        .qty(qty)
                                        .build());

        System.out.println("inMemoryRepo = " + inMemoryRepo);
    }

    @Override
    public void incrementCount() {
        int newCount = totalItemCount.incrementAndGet();
        System.out.println("newCount = " + newCount);
    }

    @Override
    public Optional<Item> loadItemByNo(String itemNo) {
        return Optional.ofNullable(inMemoryRepo.get(itemNo));
    }

    @Override
    public Integer totalItemCount() {
        return totalItemCount.get();
    }

    @Override
    public List<Item> loadAll() {
        return new ArrayList<>( inMemoryRepo.values());
    }
}
