package com.aspire.training.es.iteminventory.adapter.rest;

import com.aspire.training.es.iteminventory.adapter.rest.dto.ItemDTO;
import com.aspire.training.es.iteminventory.common.command.CreateItemCommand;
import com.aspire.training.es.iteminventory.common.command.IncreaseItemQtyCommand;
import com.aspire.training.es.iteminventory.common.command.ReduceItemQtyCommand;
import com.aspire.training.es.iteminventory.common.query.FindItemByNoQuery;
import com.aspire.training.es.iteminventory.common.query.LoadAllItemsQuery;
import com.aspire.training.es.iteminventory.common.query.TotalItemCountQuery;
import com.aspire.training.es.iteminventory.exception.NoItemFoundException;
import com.aspire.training.es.iteminventory.model.Item;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/items")
public class ItemController {


    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public ItemController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping
    public void creatingAnItem(@RequestBody @Valid ItemDTO itemDTO) {

        CreateItemCommand createItemCommand = CreateItemCommand
                .builder()
                .itemNo(itemDTO.getItemNo())
                .qty(itemDTO.getQty())
                .price(itemDTO.getPrice())
                .manId(itemDTO.getManId())
                .desc(itemDTO.getDesc())
                .imgLinks(itemDTO.getImgLinks())
                .build();

        commandGateway.sendAndWait(createItemCommand);

    }

    @PatchMapping("/{itemNo}/increment/{amount}")
    public void incrementingQty(@PathVariable("itemNo") String itemNo,
                                @PathVariable("amount") int amount) {

        IncreaseItemQtyCommand increaseItemQtyCommand = IncreaseItemQtyCommand
                .builder()
                .itemNo(itemNo)
                .amount(amount)
                .build();

        commandGateway.sendAndWait(increaseItemQtyCommand);
    }

    @PatchMapping("/{itemNo}/reduce/{amount}")
    public void reducingQty(@PathVariable("itemNo") String itemNo,
                            @PathVariable("amount") int amount) {

        ReduceItemQtyCommand reduceItemQtyCommand = ReduceItemQtyCommand
                .builder()
                .itemNo(itemNo)
                .amount(amount)
                .build();

        commandGateway.sendAndWait(reduceItemQtyCommand);
    }

    @GetMapping
    public List<ItemDTO> loadingItems() throws ExecutionException, InterruptedException {

        LoadAllItemsQuery loadAllItemsQuery = new LoadAllItemsQuery();

        List<Item> items = queryGateway
                .query(
                        loadAllItemsQuery,
                        ResponseTypes
                                .multipleInstancesOf(Item.class)).get();

        return
                items
                        .stream()
                        .map(itemToDTOMapper)
                        .collect(toList());

    }

    @GetMapping("/{itemNo}")
    public ItemDTO loadItem(@PathVariable("itemNo") String itemNo) throws ExecutionException, InterruptedException {
        FindItemByNoQuery findItemByNoQuery = new FindItemByNoQuery(itemNo);

        Optional<Item> item = queryGateway
                .query(findItemByNoQuery,
                        ResponseTypes.optionalInstanceOf(Item.class)).get();

        return item.map(itemToDTOMapper).orElseThrow(()->new NoItemFoundException());
    }

    @GetMapping("/total/count")
    public Integer totalCount() throws ExecutionException, InterruptedException {
        TotalItemCountQuery totalItemCountQuery = new TotalItemCountQuery();
        return queryGateway.query(totalItemCountQuery, Integer.class).get();

    }

    Function<Item, ItemDTO> itemToDTOMapper =
            item -> ItemDTO.builder()
                    .itemNo(item.getItemNo())
                    .qty(item.getQty())
                    .price(item.getPrice())
                    .manId(item.getManId())
                    .desc(item.getDesc())
                    .imgLinks(item.getImgLinks())
                    .build();
}
