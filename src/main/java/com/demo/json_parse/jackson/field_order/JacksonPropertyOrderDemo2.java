package com.demo.json_parse.jackson.field_order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JacksonPropertyOrderDemo2 {
    public static void main(String[] args) throws IOException {

        // Create ObjectMapper object.
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        User2 bean = new User2(1, "Ramesh", "Fadatare", "Ramesh Fadatare");
        String result = mapper.writeValueAsString(bean);

        System.out.println(result);
    }
}
