package com.demo.json_parse.jackson.serilize_deserilize.serialize.ignore_null_empty_fields.test3;


/**
 * Include.NON_NULL: Indicates that only properties with not null values will be included in JSON
 * Include.NON_EMPTY: Indicates that only properties that are not empty will be included in JSON
 */


public class Employee3 {
    private int id;

    private String firstName;

    private String lastName;

    public Employee3(int id, String firstName, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
