package com.demo.json_parse.jackson.node_model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

public class EditJsonNode {

    /**
     * 修改node
     * @throws JsonProcessingException
     */
    @Test
    public void test() throws JsonProcessingException {
        String jsonStr = "{\n" +
                "               \"name\":\"ocean\",\n" +
                "               \"age\":28,\n" +
                "               \"score\":{\"chinese\":100,\"math\":120}\n" +
                "            }";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonStr);
        ObjectNode objRootNode = (ObjectNode) rootNode;

        // 若field存在，会更新该field的值
        objRootNode.put("name","haiyang");

        System.out.println(rootNode);
        System.out.println(objRootNode);
    }



    /**
     * 修改node
     * @throws JsonProcessingException
     */
    @Test
    public void test2() throws JsonProcessingException {
        String jsonStr = "{\n" +
                "               \"name\":\"ocean\",\n" +
                "               \"age\":28,\n" +
                "               \"score\":{\"chinese\":100,\"math\":120}\n" +
                "            }";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonStr);
        JsonNode scoreNode =rootNode.get("score");
        ObjectNode objscoreNode = (ObjectNode) scoreNode;

        // 若field存在，会更新该field的值
        objscoreNode.put("math",150);

        System.out.println(objscoreNode);
        System.out.println(rootNode);
    }


    /**
     * 增加node
     * @throws JsonProcessingException
     */
    @Test
    public void test3() throws JsonProcessingException {
        String jsonStr = "{\n" +
                "               \"name\":\"ocean\",\n" +
                "               \"age\":28,\n" +
                "               \"score\":{\"chinese\":100,\"math\":120}\n" +
                "            }";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonStr);
        JsonNode scoreNode =rootNode.get("score");
        ObjectNode objscoreNode = (ObjectNode) scoreNode;

        // 若field存在，会更新该field的值
        objscoreNode.put("Eng",150);

        System.out.println(objscoreNode);
        System.out.println(rootNode);
    }

    /**
     * 增加node
     * @throws JsonProcessingException
     */
    @Test
    public void test4() throws JsonProcessingException {
        String jsonStr = "{\n" +
                "               \"name\":\"ocean\",\n" +
                "               \"age\":28,\n" +
                "               \"score\":{\"chinese\":100,\"math\":120}\n" +
                "            }";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonStr);
        ObjectNode objRootNode = (ObjectNode) rootNode;

        // 若field不存在，会新增node
        objRootNode.put("hobby","sports");

        System.out.println(rootNode);
        System.out.println(objRootNode);
    }

    @Test
    public void test5() throws IOException {
        Path path = Paths.get("suite.json");
        System.out.println(new String(Files.readAllBytes(path)));
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(path.toFile());
        ObjectNode reportSummaryObjectNode = (ObjectNode) rootNode.get("reportSummary");

        if (reportSummaryObjectNode.get("testSuiteResult").asText().equals("STARTED")) {
            reportSummaryObjectNode.put("testSuiteResult", "SKIP");
        }

        JsonNode testcaseNode = rootNode.get("testcases");
        Iterator<Map.Entry<String, JsonNode>> fields = testcaseNode.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> next = fields.next();
            JsonNode casenode = next.getValue();
            ObjectNode objnode1 = (ObjectNode) casenode;
            if (objnode1.get("state").asText().equals("STARTED")) {
                objnode1.put("state", "SKIP");
            }
        }}
}