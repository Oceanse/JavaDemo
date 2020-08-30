package com.demo.json_parse.jackson.serilize_deserilize.serialize;

import com.demo.json_parse.pojo.CaseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class SerilizitionDemo {
    /**
     * 序列化
     * Serialize Object to JSON:  Object--->json字符串
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //pojo serilization
        CaseBody c = new CaseBody();
        c.setPackageName("mygroup");
        c.setClassName("Myclass");
        c.setMethodName("mymethod");
        Map parameters = new HashMap<>();
        parameters.put("name", "ocean");
        c.setParameters(parameters);
        String jsonInString = mapper.writeValueAsString(c);//{"packageName":"mygroup","methodName":"mymethod","name":null,"parameters":{"name":"ocean"},"id":null,"configurationData":null,"className":"Myclass"}
        System.out.println(jsonInString);


        // List/Set Serialization
        List<String> progLangs = new ArrayList<>();
        //Set< String > progLangs = new HashSet< >();
        progLangs.add("C");
        progLangs.add("C++");
        progLangs.add("Java");
        progLangs.add("Java EE");
        progLangs.add("Python");
        progLangs.add("Scala");
        progLangs.add("JavaScript");
        // Serialize Object to JSON.
        String jsonArray = mapper.writeValueAsString(progLangs);
        System.out.println();
        System.out.println(jsonArray);//["Java EE","Java","C++","C","Scala","JavaScript","Python"]


        // Map Serialization
        Map < String, Integer > days = new HashMap < > ();
        days.put("MON", Calendar.MONDAY);
        days.put("TUE", Calendar.TUESDAY);
        days.put("WED", Calendar.WEDNESDAY);
        days.put("THU", Calendar.THURSDAY);
        days.put("FRI", Calendar.FRIDAY);
        days.put("SAT", Calendar.SATURDAY);
        days.put("SUN", Calendar.SUNDAY);
        String jsonMap = mapper.writeValueAsString(days);
        System.out.println();
        System.out.println(jsonMap);//{"THU":5,"TUE":3,"WED":4,"SAT":7,"FRI":6,"MON":2,"SUN":1}


    }


    /**
     * 序列化
     * Obbject 序列化成byte[]
     * @throws IOException
     */
    @Test
    public void test1_2() throws IOException {
        CaseBody c = new CaseBody();
        c.setPackageName("mygroup");
        c.setClassName("Myclass");
        c.setMethodName("mymethod");
        Map parameters = new HashMap<>();
        parameters.put("name", "ocean");
        c.setParameters(parameters);

        ObjectMapper mapper = new ObjectMapper();

        //Object--->byte[]
        byte[] bytes = mapper.writeValueAsBytes(c);

        //byte[]--->String
        String content = new String(bytes,"utf-8");
        System.out.println(content);
    }


    /**
     * 序列化
     * convert Object to JSON and write to file
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        CaseBody c = new CaseBody();
        c.setPackageName("mygroup");
        c.setClassName("Myclass");
        c.setMethodName("mymethod");
        Map parameters = new HashMap<>();
        parameters.put("name", "ocean");
        c.setParameters(parameters);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("out.txt"), c);
    }

    /**
     * 序列化
     * convert Object to JSON and write to file
     *
     * @throws IOException
     */
    @Test
    public void test2_2() throws IOException {
        CaseBody c = new CaseBody();
        c.setPackageName("mygroup");
        c.setClassName("Myclass");
        c.setMethodName("mymethod");
        Map parameters = new HashMap<>();
        parameters.put("name", "ocean");
        c.setParameters(parameters);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new FileOutputStream("testResource\\out.txt"), c);
    }

}
