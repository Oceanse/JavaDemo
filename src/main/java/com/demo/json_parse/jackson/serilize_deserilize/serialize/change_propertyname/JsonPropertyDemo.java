package com.demo.json_parse.jackson.serilize_deserilize.serialize.change_propertyname;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @JsonProperty Annotation: change the name of a field of class to map to another JSON property
 */
public class JsonPropertyDemo {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        User user=new User(1, "Ramesh", "Fadatare", "Ramesh Fadatare");
        String result = mapper.writeValueAsString(user);
        System.out.println(result);//{"id":1,"fullName":"Ramesh Fadatare","first_name":"Ramesh","last_name":"Fadatare"}
    }
}

class User {
    public int id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String fullName;


    public User(int id, String firstName, String lastName, String fullName) {
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
