package com.demo.json_parse.jackson.jsonnode.traverse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.Map;


/**
 *  Java用Jackson遍历json所有节点的最终value
 */
public class Demo2 {

    public static void jsonLeaf(JsonNode node)
    {
        if (node.isValueNode())
        {
            System.out.println(node.toString());
            return;
        }

        if (node.isObject())
        {
            Iterator<Map.Entry<String, JsonNode>> it = node.fields();
            while (it.hasNext())
            {
                Map.Entry<String, JsonNode> entry = it.next();
                jsonLeaf(entry.getValue());
            }
        }

        if (node.isArray())
        {
            Iterator<JsonNode> it = node.iterator();
            while (it.hasNext())
            {
                jsonLeaf(it.next());
            }
        }
    }

    public static void main(String[] args)
    {
        try
        {
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
            ObjectMapper jackson = new ObjectMapper();
            JsonNode node = jackson.readTree(jsonString);
            jsonLeaf(node);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
