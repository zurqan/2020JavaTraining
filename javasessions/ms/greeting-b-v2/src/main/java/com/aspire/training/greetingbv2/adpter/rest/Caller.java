package com.aspire.training.greetingbv2.adpter.rest;

import lombok.Data;

@Data
public class Caller {

    public static final Caller EMPTY = new Caller();
    private String id;
    private String name;
    private int age;
    private GENDER gender;

}
