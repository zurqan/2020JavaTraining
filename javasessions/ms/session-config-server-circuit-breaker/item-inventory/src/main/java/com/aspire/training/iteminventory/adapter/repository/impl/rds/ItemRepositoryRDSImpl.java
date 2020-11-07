package com.aspire.training.iteminventory.adapter.repository.impl.rds;

import com.aspire.training.iteminventory.model.Item;
import com.aspire.training.iteminventory.model.ItemDescription;
import com.aspire.training.iteminventory.model.Manufacturer;
import com.aspire.training.iteminventory.model.Price;
import com.aspire.training.iteminventory.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ItemRepositoryRDSImpl implements ItemRepository {

    private final ItemRepositoryRDS itemRepositoryRDS;


    public ItemRepositoryRDSImpl(ItemRepositoryRDS itemRepositoryRDS) {
        this.itemRepositoryRDS = itemRepositoryRDS;
    }

    @Override
    public void addItem(Item item) {

        itemRepositoryRDS.save(toItemEntityMapper.apply(item));

    }

    @Override
    public boolean updateItem(Item item) {

        return loadItem(item.getItemId())
                .map(i -> item)
                .map(toItemEntityMapper)
                .map(itemRepositoryRDS::save)
                .map(e -> true)
                .orElse(false);

    }

    @Override
    public Optional<Item> loadItem(String itemId) {

        return itemRepositoryRDS
                .findById(itemId)
                .map(toItemModelMapper);

    }

    @Override
    public List<Item> itemsShortDesc(String desc) {
        return itemRepositoryRDS
                .findByShortDescContaining(desc)
                .stream()
                .map(toItemModelMapper)
                .collect(Collectors.toList());
    }

    private Function<Item, ItemEntity> toItemEntityMapper = item ->
            ItemEntity.builder()
                    .id(item.getItemId())
                    .price(item.getPrice().getValue())
                    .longDesc(item.getItemDescription().getLongDescription())
                    .shortDesc(item.getItemDescription().getShortDescription())
                    .manName(item.getManufacturer().getName())
                    .manPhone(item.getManufacturer().getPhone())
                    .build();

    private Function<? super ItemEntity, ? extends Item> toItemModelMapper =
            itemEntity ->
                    Item
                            .builder()
                            .itemId(itemEntity.getId())
                            .manufacturer(new Manufacturer(itemEntity.getManName(), itemEntity.getManPhone()))
                            .itemDescription(new ItemDescription(itemEntity.getShortDesc(), itemEntity.getLongDesc()))
                            .price(new Price(itemEntity.getPrice()))
                            .build();
}
