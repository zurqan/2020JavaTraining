package com.aspire.training.iteminventory.adapter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDTO {

    private String id;

    @Min(0)
    private int price;


    private String longDesc;

    @NotEmpty
    private String shortDesc;

    @NotEmpty
    private String manName;

    private String manPhone;


}
