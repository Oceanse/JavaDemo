package com.demo.json_parse.gson;

import com.google.gson.stream.JsonReader;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.StringReader;

/**
 * 使用stream包下的JsonReader类来手动实现反序列化
 */
public class GsonDemo33 {
    @Test
    public void test() throws IOException {
        String json = "{\"name\":\"张三\",\"age\":\"24\"}";
        Doctor doctor = new Doctor();
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginObject();
        System.out.println(reader.nextName());
        System.out.println(reader.nextString());
    }

    @Test
    public void test2() throws IOException {
        String json = "{\"name\":\"张三\",\"age\":\"24\"}";
        Doctor doctor = new Doctor();
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginObject();
        while (reader.hasNext()) {
            System.out.println(reader.nextName()+":"+reader.nextString());
        }
    }

    @Test
    public void test3() throws IOException {
        String json = "{\"name\":\"张三\",\"age\":\"24\"}";
        Doctor doctor = new Doctor();
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginObject();
        while (reader.hasNext()) {
            String s = reader.nextName();
            switch (s) {
                case "name":
                    doctor.name = reader.nextString();
                    break;
                case "age":
                    doctor.age = reader.nextInt(); //自动转换
                    break;
                case "email":
                    doctor.emailAddress = reader.nextString();
                    break;
            }
        }
        reader.endObject(); // throws IOException
        System.out.println(doctor.name);  //张三
        System.out.println(doctor.age);   // 24
        System.out.println(doctor.emailAddress); //null
    }



}
