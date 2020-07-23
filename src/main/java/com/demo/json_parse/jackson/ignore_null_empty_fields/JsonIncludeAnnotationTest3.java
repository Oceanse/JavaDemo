package com.demo.json_parse.jackson.ignore_null_empty_fields;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


/**
 * Using Include.NON_NULL and Include.NON_EMPTY globally with ObjectMapper
 * Jackson also allows configuring this behavior globally on the ObjectMapper:
 */
public class JsonIncludeAnnotationTest3 {
    public static void main(String[] args) throws JsonProcessingException {

        // Create ObjectMapper object.
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //null and empty field will not be included in json
        Employee employee = new Employee(10, null, "");
        String result = mapper.writeValueAsString(employee);

        System.out.println(result);

    }
}
