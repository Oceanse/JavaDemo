package com.demo.json_parse.jackson.pretty_print;

import com.demo.json_parse.pojo.CaseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * 格式化json格式
 * I found two ways we can configure and enable pretty print JSON with ObjectMapper class.
 *
 * Using ObjectMapper.writerWithDefaultPrettyPrinter() Method
 * Using ObjectMapper.enable(SerializationFeature.INDENT_OUTPUT) Method
 */
public class PrettyPrint {


    /**
     * writerWithDefaultPrettyPrinter
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //pojo serilization
        CaseBody c = new CaseBody();
        c.setPackageName("mygroup");
        c.setClassName("Myclass");
        c.setMethodName("mymethod");
        Map parameters = new HashMap<>();
        parameters.put("name", "ocean");
        c.setParameters(parameters);
        String jsonInString = mapper.writeValueAsString(c);//{"packageName":"mygroup","methodName":"mymethod","name":null,"parameters":{"name":"ocean"},"id":null,"configurationData":null,"className":"Myclass"}
        System.out.println(jsonInString);

        System.out.println();
        String jsonPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(c);
        System.out.println(jsonPretty);
    }


    /**
     * enable(SerializationFeature.INDENT_OUTPUT)
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //pojo serilization
        CaseBody c = new CaseBody();
        c.setPackageName("mygroup");
        c.setClassName("Myclass");
        c.setMethodName("mymethod");
        Map parameters = new HashMap<>();
        parameters.put("name", "ocean");
        c.setParameters(parameters);
        String jsonInString = mapper.writeValueAsString(c);//{"packageName":"mygroup","methodName":"mymethod","name":null,"parameters":{"name":"ocean"},"id":null,"configurationData":null,"className":"Myclass"}
        System.out.println(jsonInString);

        System.out.println();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jsonPretty = mapper.writeValueAsString(c);
        System.out.println(jsonPretty);
    }
}