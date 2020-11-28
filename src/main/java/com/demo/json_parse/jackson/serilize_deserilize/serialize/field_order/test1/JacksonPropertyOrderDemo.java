package com.demo.json_parse.jackson.serilize_deserilize.serialize.field_order.test1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JacksonPropertyOrderDemo {
    public static void main(String[] args) throws IOException {

        // Create ObjectMapper object.
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        User bean = new User(1, "Ramesh", "Fadatare", "Ramesh Fadatare");
        String result = mapper.writeValueAsString(bean);

        System.out.println(result);
    }
}
