package com.demo.json_parse.jackson.jsonnode.traverse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * JsonNode_Object_convert is Jackson's tree model (object graph model) for JSON
 * Jackson can read JSON into a JsonNode_Object_convert instance(deserialize ), and write a JsonNode_Object_convert out to JSON(serialize)
 */
public class Demo1 {


    /**
     * 遍历rootNode(objectnode)下的所有键值对，但是每个键值对的值可能还是个Objectnode或者Arraynode
     * {
     * "name":"ocean",
     * "age":28,
     * "hobby":["music","code"],
     * "score":{
     * "chinese":100,
     * "math":120
     * }
     * }
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
                "    \"name\":\"ocean\",\n" +
                "    \"age\":28,\n" +
                "    \"hobby\":[\n" +
                "        \"music\",\n" +
                "        \"code\"],\n" +
                "    \"score\":{\n" +
                "        \"chinese\":100,\n" +
                "        \"math\":120\n" +
                "    }\n" +
                "}";


        JsonNode rootNode = mapper.readTree(jsonString);
        Iterator<Map.Entry<String, JsonNode>> it = rootNode.fields();//遍历rootNode下的所有键值对
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> entry = it.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }


    /**
     * 遍历所有的键和值
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
                "    \"name\":\"ocean\",\n" +
                "    \"age\":28,\n" +
                "    \"hobby\":[\n" +
                "        \"music\",\n" +
                "        \"code\"],\n" +
                "    \"score\":{\n" +
                "        \"chinese\":100,\n" +
                "        \"math\":120\n" +
                "    }\n" +
                "}";

        Map<String, String> container = new HashMap<>();
        JsonNode rootNode = mapper.readTree(jsonString);
        Iterator<Map.Entry<String, JsonNode>> it = rootNode.fields();//遍历rootNode下的所有键值对
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> entry = it.next();
            container.put(entry.getKey(),  entry.getValue().toString());
        }
        System.out.println(container);
    }


    /**
     * 遍历arrayNode下的所有键值对，但是每个元素可能还是个Objectnode或者valuenode
     * {
     * "name":"ocean",
     * "age":28,
     * "hobby":["music","code"],
     * "score":{
     * "chinese":100,
     * "math":120
     * }
     * }
     *
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
                "    \"name\":\"ocean\",\n" +
                "    \"age\":28,\n" +
                "    \"hobby\":[\n" +
                "        \"music\",\n" +
                "        \"code\"],\n" +
                "    \"score\":{\n" +
                "        \"chinese\":100,\n" +
                "        \"math\":120\n" +
                "    }\n" +
                "}";


        JsonNode hobbyNode = mapper.readTree(jsonString).get("hobby");
        Iterator<JsonNode> it = hobbyNode.iterator();
        while (it.hasNext()) {
            JsonNode next = it.next();
            System.out.println(next);
        }
    }


    /**
     * 遍历所有的值
     *
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
                "    \"name\":\"ocean\",\n" +
                "    \"age\":28,\n" +
                "    \"hobby\":[\n" +
                "        \"music\",\n" +
                "        \"code\"],\n" +
                "    \"score\":{\n" +
                "        \"chinese\":100,\n" +
                "        \"math\":120\n" +
                "    }\n" +
                "}";


        JsonNode rootNode = mapper.readTree(jsonString);
        Iterator<JsonNode> iterator = rootNode.iterator();
        while (iterator.hasNext()) {
            JsonNode next = iterator.next();
            System.out.println(next);
        }
    }


    @Test
    public void test5() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
                "    \"name\":\"ocean\",\n" +
                "    \"age\":28,\n" +
                "    \"hobby\":[\n" +
                "        \"music\",\n" +
                "        \"code\"],\n" +
                "    \"score\":{\n" +
                "        \"chinese\":100,\n" +
                "        \"math\":120\n" +
                "    }\n" +
                "}";


        JsonNode rootNode = mapper.readTree(jsonString);
        Iterator<String> keys = rootNode.fieldNames();

        //遍历所有key-value
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(key+":"+rootNode.get(key));
        }

    }



}
