package com.aspire.training.ms.session1.httpverbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;

    @NotEmpty
    private String name;

    @Min(10)
    private int age;

}
