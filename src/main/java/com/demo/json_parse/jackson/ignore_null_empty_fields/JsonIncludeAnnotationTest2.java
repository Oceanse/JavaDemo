package com.demo.json_parse.jackson.ignore_null_empty_fields;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonIncludeAnnotationTest2 {
    public static void main(String[] args) throws JsonProcessingException {

        // Create ObjectMapper object.
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        //null and empty field will not be included in json
        Employee employee = new Employee(10, null, "");
        String result = mapper.writeValueAsString(employee);

        System.out.println(result);

    }
}
