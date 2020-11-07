package com.aspire.training.iteminventory.adapter.rest;

import com.aspire.training.iteminventory.adapter.rest.dto.ItemDTO;
import com.aspire.training.iteminventory.exceptions.ItemNotFoundException;
import com.aspire.training.iteminventory.model.Item;
import com.aspire.training.iteminventory.model.ItemDescription;
import com.aspire.training.iteminventory.model.Manufacturer;
import com.aspire.training.iteminventory.model.Price;
import com.aspire.training.iteminventory.service.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping
    public String addingItem(@RequestBody @Valid ItemDTO itemDTO){

        itemDTO.setId(UUID.randomUUID().toString());

        Item item = toItemModelMapper.apply(itemDTO);


        itemService.addItem(item);

        return item.getItemId();
    }

    @GetMapping("{itemId}")
    public ItemDTO loadingItem(@PathVariable("itemId") String itemId){

        return
                itemService
                .loadItem(itemId)
                .map(toDtoMapper)
                .orElseThrow(()->new ItemNotFoundException(itemId));
    }

    @GetMapping("/search")
    public List<ItemDTO> searchItemByDesc(@RequestParam("short") String shortDesc){

        return itemService
                .searchByDescription(shortDesc)
                .stream()
                .map(toDtoMapper)
                .collect(Collectors.toList());
    }


    private Function<ItemDTO, Item> toItemModelMapper=
            dto-> Item
                    .builder()
                    .itemId(dto.getId())
                    .price(new Price(dto.getPrice()))
                    .itemDescription(new ItemDescription(dto.getShortDesc(),dto.getLongDesc()))
                    .manufacturer(new Manufacturer(dto.getManName(),dto.getManPhone()))
                    .build();


    private Function<Item, ItemDTO> toDtoMapper=
            item->
                    ItemDTO.builder()
                            .id(item.getItemId())
                            .price(item.getPrice().getValue())
                            .longDesc(item.getItemDescription().getLongDescription())
                            .shortDesc(item.getItemDescription().getShortDescription())
                            .manName(item.getManufacturer().getName())
                            .manPhone(item.getManufacturer().getPhone())
                            .build();

}
