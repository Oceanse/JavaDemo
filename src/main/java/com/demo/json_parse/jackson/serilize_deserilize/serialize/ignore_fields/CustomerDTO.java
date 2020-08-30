package com.demo.json_parse.jackson.serilize_deserilize.serialize.ignore_fields;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * 序列化时候忽略某些字段
 * Let's demonstrate how to ignore certain fields when serializing an object to JSON using Jackson with examples.
 */
public class CustomerDTO {

    @JsonIgnore
    private final String id;
    private final String firstName;
    private final String lastName;

    public CustomerDTO(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}