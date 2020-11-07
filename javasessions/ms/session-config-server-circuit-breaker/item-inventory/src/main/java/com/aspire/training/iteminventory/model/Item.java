package com.aspire.training.iteminventory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Item {

    private String itemId;

    private Price price;

    private ItemDescription itemDescription;

    private Manufacturer manufacturer;//TODO id
}
