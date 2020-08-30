package com.demo.json_parse.jackson.serilize_deserilize;

import com.demo.json_parse.pojo.CaseBody;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


/**
 * ObjectMapper对象，序列化和反序列化都需要它
 */
public class Deserilization {



    /**
     * 反序列化: JSON from String to Object
     * DeSerialize: Converting JSON from file/url/string to Object
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //JSON from String to Object
        String jsonInString = "{\"packageName\":\"mygroup\",\"methodName\":\"mymethod\",\"className\":\"Myclass\"}";
        CaseBody obj = mapper.readValue(jsonInString, CaseBody.class);
        System.out.println(obj);
    }




    /**
     * 反序列化: JSON from String to Object
     * json字符串存在多余的字段时候会产生UnrecognizedPropertyException
     *
     * @throws IOException
     */
    @Test
    public void test1_2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //JSON from String to Object
        String jsonInString = "{\"mypackage\":\"mygroup\",\"methodName\":\"mymethod\",\"className\":\"Myclass\"}";
        CaseBody obj = mapper.readValue(jsonInString, CaseBody.class);
        System.out.println(obj);
    }

    /**
     * 反序列化: JSON from String to Object
     * json字符串相对javabean缺少的字段对应的对象属性是默认值
     *
     * @throws IOException
     */
    @Test
    public void test1_3() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //JSON from String to Object
        String jsonInString = "{\"methodName\":\"mymethod\",\"className\":\"Myclass\"}";
        CaseBody obj = mapper.readValue(jsonInString, CaseBody.class);
        System.out.println(obj);
    }


    /**
     * 反序列化
     * DeSerialize: Converting JSON from file/url/string to Object
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //JSON from file to Object
        CaseBody obj2 = mapper.readValue(new File("testResource\\out.txt"), CaseBody.class);
        CaseBody obj3 = mapper.readValue(new FileInputStream("testResource\\out.txt"), CaseBody.class);
        System.out.println(obj2);
        System.out.println(obj3);

        // //JSON from byte[] to Object
        byte[] bytes = Files.readAllBytes(Paths.get("testResource\\out.txt"));
        CaseBody obj4 = mapper.readValue(bytes, CaseBody.class);


        //JSON from URL to Object
        //CaseBody obj3 = mapper.readValue(new URL("http://www.jianshu.com/u/c38e94dcec65"), CaseBody.class);


    }


    /**
     * List/Set/Map  Deserialization
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "[ \"C\", \"C++\", \"Java\", \"Java EE\", \"Python\", \"Scala\", \"JavaScript\" ]";


        List < String > progLangs;
        progLangs = mapper.readValue(json, List.class);
        System.out.println(progLangs);

        Set < String > progLangs2;
        progLangs2 = mapper.readValue(json, Set.class);
        System.out.println(progLangs2);

        String json2 = "{" +
                "  \"THU\" : 5," +
                "  \"TUE\" : 3," +
                "  \"WED\" : 4," +
                "  \"SAT\" : 7," +
                "  \"FRI\" : 6," +
                "  \"MON\" : 2," +
                "  \"SUN\" : 1" +
                "}";

        @SuppressWarnings("unchecked")
        Map < String, Integer > days = mapper.readValue(json2, Map.class);
        System.out.println(days);
    }
}
