package com.demo.json_parse.jackson.jsonnode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonNode_Object_convert {

    /**
     * class对象转成JsonNode
     * new ObjectMapper().convertValue(obj, JsonNode_Object_convert.class)
     * @throws JsonProcessingException
     */
    @Test
    public static void test() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String str="[\n" +
                "\t{\n" +
                "\t\t\"Value\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"value\": \"v1\"\n" +
                "\t\t},\n" +
                "\t\t\"Name\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"value\": \"k1\"\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"Value\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"value\": \"v2\"\n" +
                "\t\t},\n" +
                "\t\t\"Name\": {\n" +
                "\t\t\t\"type\": \"string\",\n" +
                "\t\t\t\"value\": \"k2\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "]";

        List<Map<String,String>> mapList = mapper.readValue(str, List.class);
        Map<JsonNode, JsonNode> collect = mapList.stream().map(obj -> new ObjectMapper().convertValue(obj, JsonNode.class)).collect(Collectors.toMap(
                jsonNode -> {
                    return jsonNode.get("Name").get("value");
                }, jsonNode -> {
                    return jsonNode.get("Value").get("value");
                }
        ));
        System.out.println(collect);
    }




}
