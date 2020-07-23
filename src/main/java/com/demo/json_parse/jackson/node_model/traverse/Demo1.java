package com.demo.json_parse.jackson.node_model.traverse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


/**
 * JsonNode is Jackson's tree model (object graph model) for JSON
 * Jackson can read JSON into a JsonNode instance(deserialize ), and write a JsonNode out to JSON(serialize)
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

}
