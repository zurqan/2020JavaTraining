package com.aspire.training.es.iteminventory.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@Builder(toBuilder = true)
public class Item {

    private String itemNo;

    private String desc;
    private List<String> imgLinks;
    private double price;
    private int qty;
    private String manId;
}
