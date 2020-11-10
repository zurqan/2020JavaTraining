package com.aspire.training.iteminventory.adapter.repository.impl.mongo.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDocument {

    @Id
    private String id;

    @Field("pr")
    @Indexed
    private int price;

    @Field("sd")
    private String shortDesc;

    @Field("ld")
    private String longDesc;

    @Field("mp")
    private String manPhone;

    @Field("mn")
    private String manName;
}
