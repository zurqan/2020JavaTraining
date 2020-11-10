package com.aspire.training.iteminventory.adapter.repository.impl.mongo;

import com.aspire.training.iteminventory.adapter.repository.impl.mongo.collections.ItemDocument;
import com.aspire.training.iteminventory.model.Item;
import com.aspire.training.iteminventory.model.ItemDescription;
import com.aspire.training.iteminventory.model.Manufacturer;
import com.aspire.training.iteminventory.model.Price;
import com.aspire.training.iteminventory.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ItemMongoRepositoryImpl implements ItemRepository {

    private final ItemNoSQLRepository itemNoSQLRepository;

    public ItemMongoRepositoryImpl(ItemNoSQLRepository itemNoSQLRepository) {
        this.itemNoSQLRepository = itemNoSQLRepository;
    }

    @Override
    public void addItem(Item item) {

        itemNoSQLRepository
                .save(toDocumentMapper.apply(item));
    }

    @Override
    public boolean updateItem(Item item) {

        return loadItem(item.getItemId())
                .map(old->item)
                .map(toDocumentMapper)
                .map(itemNoSQLRepository::save)
                .map(i->true)
                .orElse(false);
    }

    @Override
    public Optional<Item> loadItem(String itemId) {

        return itemNoSQLRepository
                .findById(itemId)
                .map(toItemModel);
    }

    @Override
    public List<Item> itemsShortDesc(String desc) {

        return itemNoSQLRepository
                .findByShortDescContaining(desc)
                .stream()
                .map(toItemModel)
                .collect(Collectors.toList());
    }

    private Function<Item, ItemDocument> toDocumentMapper =
            item ->
                    ItemDocument.builder()
                            .id(item.getItemId())
                            .price(item.getPrice().getValue())
                            .longDesc(item.getItemDescription().getLongDescription())
                            .shortDesc(item.getItemDescription().getShortDescription())
                            .manName(item.getManufacturer().getName())
                            .manPhone(item.getManufacturer().getPhone())
                            .build();

    private Function<ItemDocument, Item> toItemModel =
            itemDocument ->
                    Item
                            .builder()
                            .itemId(itemDocument.getId())
                            .manufacturer(new Manufacturer(itemDocument.getManName(), itemDocument.getManPhone()))
                            .itemDescription(new ItemDescription(itemDocument.getShortDesc(), itemDocument.getLongDesc()))
                            .price(new Price(itemDocument.getPrice()))
                            .build();
}
