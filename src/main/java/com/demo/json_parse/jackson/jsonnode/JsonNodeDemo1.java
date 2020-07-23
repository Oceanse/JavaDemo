package com.demo.json_parse.jackson.jsonnode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonNodeDemo1 {
    @Test
    public void test() throws IOException {
        // 实例化 ObjectMapper 对象
        ObjectMapper objectMapper = new ObjectMapper();

        // json 消息
        String json = "{\"firstname\":\"Bo\",\"lastname\":\"Shang\",\"age\":30}";

        // 将 json 转成 JsonNode 对象
        JsonNode rootNode = objectMapper.readTree(json);

        JsonNode firstNameNode = rootNode.get("firstname");
        String firstName = firstNameNode.asText();
        System.out.println("firstname:" + firstNameNode.asText());

        JsonNode lastnameNode = rootNode.get("lastname");
        String lastname = firstNameNode.asText();
        System.out.println("lastname:" + lastnameNode.asText());

        JsonNode ageNode = rootNode.get("age");
        int age = ageNode.asInt();
        System.out.println("age:" + age);
    }


    @Test
    public void test2() throws IOException {
        // 实例化 ObjectMapper 对象
        ObjectMapper objectMapper = new ObjectMapper();

        // json 消息
        String json = "{\n" +
                "               \"name\":\"ocean\",\n" +
                "               \"age\":28,\n" +
                "               \"score\":{\"chinese\":100,\"math\":120}\n" +
                "            }";

        //获取rootNode
        JsonNode rootNode = objectMapper.readTree(json);
        System.out.println(rootNode);

        //获取子scoreNode
        JsonNode scoreNode = rootNode.get("score");
        System.out.println(scoreNode);

        //获取chinese成绩
        JsonNode chineseNode = scoreNode.get("chinese");
        System.out.println(chineseNode.asText());

        //获取math成绩
        System.out.println(scoreNode.get("math").asText());
        //等价于
        System.out.println(rootNode.get("score").get("math").asText());

        //获取name
        System.out.println(rootNode.get("name").asText());

    }


    /**
     * objectMapper.readTree(String json)
     * @throws JsonProcessingException
     */
    @Test
    public void test3() throws JsonProcessingException {
        // 实例化 ObjectMapper 对象
        ObjectMapper objectMapper = new ObjectMapper();

        // json 消息
        String json = "{\n" +
                "               \"name\":\"ocean\",\n" +
                "               \"age\":28,\n" +
                "               \"score\":{\"chinese\":100,\"math\":120}\n" +
                "            }";

        //获取rootNode
        JsonNode rootNode = objectMapper.readTree(json);
        //获取name
        System.out.println(rootNode.path("name").asText());

        //获取子scoreNode
        JsonNode scoreNode = rootNode.path("score");
        System.out.println(scoreNode);


        //获取math成绩
        System.out.println(scoreNode.path("math").asText());
        //等价于
        System.out.println(rootNode.path("score").path("math").asText());
    }


    /**
     * JsonNode rootNode = objectMapper.readTree(File file);
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {


        // 实例化 ObjectMapper 对象
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // json 消息
        File path = new File("suite.json");

        //获取rootNode
        JsonNode rootNode = objectMapper.readTree(path);

        //获取testcasesNode
        JsonNode testcaseNode = rootNode.get("testcases");
        System.out.println(testcaseNode);//注意不要写成System.out.println(testcaseNode.asText());

        System.out.println();
        System.out.println(testcaseNode.get("1").get("fullName").asText());
    }
}