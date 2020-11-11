package com.aspire.training.accountenentsourcing.adapter.rest.dto;

import com.aspire.training.accountenentsourcing.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private String id;

    private String name;

    private AccountType accountType;

    private double balance;
}
