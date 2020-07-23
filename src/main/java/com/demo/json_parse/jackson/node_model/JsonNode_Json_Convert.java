package com.demo.json_parse.jackson.node_model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;

public class JsonNode_Json_Convert {


    /**
     * Json--->JsonNode
     * JsonNode--->Json
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
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

        //Json--->JsonNode
        JsonNode rootNode = mapper.readTree(jsonString);

        //JsonNode--->Json
        String json = mapper.writeValueAsString(rootNode);
    }

}
