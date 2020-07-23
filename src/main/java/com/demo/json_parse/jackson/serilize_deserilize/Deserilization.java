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
     * 反序列化
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

        //JSON from file to Object
        CaseBody obj2 = mapper.readValue(new File("out.txt"), CaseBody.class);
        CaseBody obj3 = mapper.readValue(new FileInputStream("out.txt"), CaseBody.class);
        System.out.println(obj2);
        System.out.println(obj3);

        // //JSON from byte[] to Object
        byte[] bytes = Files.readAllBytes(Paths.get("out.txt"));
        CaseBody obj4 = mapper.readValue(bytes, CaseBody.class);


        //JSON from URL to Object
        //CaseBody obj3 = mapper.readValue(new URL("http://www.jianshu.com/u/c38e94dcec65"), CaseBody.class);

        Map<String, Object> map2 = mapper.readValue(jsonInString, new TypeReference<Map<String, Object>>() {
        });

    }


    /**
     * List/Set/Map  Deserialization
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "[ \"C\", \"C++\", \"Java\", \"Java EE\", \"Python\", \"Scala\", \"JavaScript\" ]";


        List < String > progLangs = new ArrayList < > ();
        progLangs = mapper.readValue(json, List.class);
        System.out.println(progLangs);

        Set < String > progLangs2 = new HashSet < > ();
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
