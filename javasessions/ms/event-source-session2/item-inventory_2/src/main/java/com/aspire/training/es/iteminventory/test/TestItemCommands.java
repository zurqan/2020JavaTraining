package com.aspire.training.es.iteminventory.test;

import com.aspire.training.es.iteminventory.common.command.CreateItemCommand;
import com.aspire.training.es.iteminventory.common.command.IncreaseItemQtyCommand;
import com.aspire.training.es.iteminventory.common.command.ReduceItemQtyCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class TestItemCommands implements CommandLineRunner {

    private final CommandGateway commandGateway;

    public TestItemCommands(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public void run(String... args) throws Exception {

        String itemNo = "1010";
        CreateItemCommand createItemCommand = CreateItemCommand
                .builder()
                .itemNo(itemNo)
                .desc("First Added Item")
                .manId("1010 man")
                .price(100)
                .qty(100)
                .build();

        commandGateway.sendAndWait(createItemCommand);

        IncreaseItemQtyCommand increaseItemQtyCommand = IncreaseItemQtyCommand
                .builder()
                .itemNo(itemNo)
                .amount(20)
                .build();

        commandGateway.sendAndWait(increaseItemQtyCommand);

        ReduceItemQtyCommand reduceItemQtyCommand = ReduceItemQtyCommand
                .builder()
                .itemNo(itemNo)
                .amount(80)
                .build();

        commandGateway.sendAndWait(reduceItemQtyCommand);


    }
}
