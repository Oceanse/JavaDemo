package com.demo.json_parse.jackson.node_model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * JsonNode可以看作是json的tree mode, JsonNode三种类型： valuenode, objectnode, arraynode
 * valuenode: jsonnode对应的是一个具体的值，不是键值对或者数组
 * objectnode:jsonnode对应的是一个json对象{key1:value1,key2:value2...}
 * arraynode: jsonnode对应的是一个数组[a,b,{key,value}]
 *
 *
 * <p>
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
public class JsonNodeType {

    @Test
    public void test() throws JsonProcessingException {
        String json = "{\"name\":\"ocean\", \"age\":28 }";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);
        System.out.println(rootNode.isValueNode());
        System.out.println(rootNode.isObject());
        System.out.println(rootNode.isArray());

        String json2 = "{\"name\":\"ocean\"}";
        ObjectMapper mapper2 = new ObjectMapper();
        JsonNode rootNode2 = mapper.readTree(json);
        System.out.println();
        System.out.println(rootNode.isValueNode());
        System.out.println(rootNode.isObject());
        System.out.println(rootNode.isArray());
    }

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
        //获取rootNode
        JsonNode rootNode = mapper.readTree(jsonString);
        System.out.println(rootNode.isValueNode());
        System.out.println(rootNode.isObject());
        System.out.println(rootNode.isArray());


        //获取nameNode,并且判断nameNode的类型
        System.out.println();
        JsonNode nameNode = rootNode.get("name");
        System.out.println(nameNode.isValueNode());
        System.out.println(nameNode.isObject());
        System.out.println(nameNode.isArray());

        //获取scoreNode,并且判断scoreNode的类型
        System.out.println();
        JsonNode scoreNode = rootNode.get("score");
        System.out.println(scoreNode.isValueNode());
        System.out.println(scoreNode.isObject());
        System.out.println(scoreNode.isArray());

        //获取hobbyNode,并且判断hobbyNode的类型
        System.out.println();
        JsonNode hobbyNode = rootNode.get("hobby");
        System.out.println(hobbyNode.isValueNode());
        System.out.println(hobbyNode.isObject());
        System.out.println(hobbyNode.isArray());
    }



}
