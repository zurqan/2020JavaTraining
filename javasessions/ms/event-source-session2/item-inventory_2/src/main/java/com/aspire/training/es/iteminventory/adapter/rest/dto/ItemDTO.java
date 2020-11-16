package com.aspire.training.es.iteminventory.adapter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    @NotEmpty
    private String itemNo;

    @NotEmpty
    private String desc;

    private List<String> imgLinks;

    private double price;
    @Min(0)
    private int qty;
    private String manId;

}
