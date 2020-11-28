package com.demo.json_parse.jackson.jsonnode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class ConvertJsonNodeType {


    /**
     * {
     * "name":"ocean",
     * "age":28,
     * "hobby":[
     * "music",
     * "code",
     * {
     * "name":"ocean"
     * }
     * ],
     * "score":{
     * "chinese":100,
     * "math":120
     * }
     * }
     *
     * @throws JsonProcessingException
     */
    @Test
    public void test() throws JsonProcessingException {
        String json = "{\n" +
                "    \"name\":\"ocean\",\n" +
                "    \"age\":28,\n" +
                "    \"hobby\":[\n" +
                "        \"music\",\n" +
                "        \"code\",\n" +
                "        {\n" +
                "            \"name\":\"ocean\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"score\":{\n" +
                "        \"chinese\":100,\n" +
                "        \"math\":120\n" +
                "    }\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);

        //返回valuenode的String形式
        JsonNode nameNode = rootNode.get("name");
        String name = nameNode.asText();
        System.out.println(name);

        //返回valuenode的int形式
        JsonNode ageNode = rootNode.get("age");
        int age = ageNode.asInt();
        System.out.println(age);


    }


    @Test
    public void test2() throws JsonProcessingException {
        String json = "{\n" +
                "    \"name\":\"ocean\",\n" +
                "    \"age\":28,\n" +
                "    \"hobby\":[\n" +
                "        \"music\",\n" +
                "        \"code\",\n" +
                "        {\n" +
                "            \"name\":\"ocean\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"score\":{\n" +
                "        \"chinese\":100,\n" +
                "        \"math\":120\n" +
                "    }\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode scoretNode = mapper.readTree(json).get("score");
        JsonNode hobbytNode = mapper.readTree(json).get("hobby");

        //对象/数组node不能转成String,类型转换有错时将不能被打印
        String score = scoretNode.asText();
        String hobby = hobbytNode.asText();
        System.out.println(score);
        System.out.println(hobby);
    }
}
