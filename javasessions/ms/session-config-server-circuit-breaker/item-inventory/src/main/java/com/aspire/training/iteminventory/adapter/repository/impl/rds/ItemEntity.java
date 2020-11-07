package com.aspire.training.iteminventory.adapter.repository.impl.rds;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ItemEntity {

    @Id
    private String id;

    private int price;

    private String shortDesc;

    private String longDesc;

    private String manPhone;

    private String manName;

}
