package com.aspire.training.accountenentsourcing.adapter.rest;

import com.aspire.training.accountenentsourcing.adapter.rest.dto.AccountDTO;
import com.aspire.training.accountenentsourcing.common.command.CreateAccountCommand;
import com.aspire.training.accountenentsourcing.common.command.DepositAmountCommand;
import com.aspire.training.accountenentsourcing.common.command.WithDrawCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/account")
public class AccountController {


    private final CommandGateway commandGateway;

    public AccountController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public ResponseEntity<EntityModel< AccountDTO>> openingAccount(@RequestBody AccountDTO accountDTO){


        CreateAccountCommand createAccountCommand = CreateAccountCommand
                .builder()
                .accountId(accountDTO.getId())
                .accountType(accountDTO.getAccountType())
                .name(accountDTO.getName())
                .build();

        commandGateway.sendAndWait(createAccountCommand);

        EntityModel<AccountDTO> accountDTOEntityModel = EntityModel
                .of(accountDTO)
                .add(linkTo(methodOn(AccountController.class).loadingAccount(accountDTO.getId())).withRel("view"))
                .add(linkTo(methodOn(AccountController.class).updatingAccount(accountDTO.getId(),accountDTO)).withRel("update"))
                .add(linkTo(methodOn(AccountController.class).closingAccount(accountDTO.getId())).withRel("close"));



        return ResponseEntity.ok(accountDTOEntityModel);
    }

    @PatchMapping("/{accountId}/deposit/{amount}")
    public void depositing(@PathVariable("accountId") String accountId,
                           @PathVariable("amount") double amount){

        DepositAmountCommand depositAmountCommand = DepositAmountCommand
                .builder()
                .accountId(accountId)
                .amount(amount)
                .build();

        commandGateway.sendAndWait(depositAmountCommand);

    }
    @PatchMapping("/{accountId}/withdraw/{amount}")
    public void withdraw(@PathVariable("accountId") String accountId,
                           @PathVariable("amount") double amount){

        WithDrawCommand withDrawCommand = WithDrawCommand
                .builder()
                .accountId(accountId)
                .amount(amount)
                .build();

        commandGateway.sendAndWait(withDrawCommand);

    }

    @GetMapping("/{accountId}")
    public AccountDTO loadingAccount(@PathVariable("accountId") String accountId){

        return AccountDTO.builder().build();
    }

    @PutMapping("/{accountId}")
    public AccountDTO updatingAccount(@PathVariable("accountId") String accountId,@RequestBody AccountDTO accountDTO){

        return accountDTO;
    }

    @DeleteMapping("/{accountId}")
    public AccountDTO closingAccount(@PathVariable("accountId") String accountId){

        return AccountDTO.builder().build();
    }
}
