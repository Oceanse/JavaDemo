package com.demo.json_parse.jackson.serilize_deserilize.serialize.field_order;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * @JsonPropertyOrder指定序列化之后json字段的顺序
 * Jackson library provides a @JsonPropertyOrder annotation to specify the order of properties on serialization.
 */
@JsonPropertyOrder(alphabetic=true)
public class User2 {
    public int id;

    private String firstName;

    private String lastName;

    private String fullName;

    public User2(int id, String firstName, String lastName, String fullName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
