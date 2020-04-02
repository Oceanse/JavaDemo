package com.demo.json_parse.gson;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Gson的流式序列化
 */
public class GsonDemo44 {

    /**
     * 自动方式
     */
    @Test
    public void test5(){
        Gson gson = new Gson();
        Doctor doctor = new Doctor("张三",24,null);
        gson.toJson(doctor,System.out);// 写到控制台
    }


    /**
     * 手动方式
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(System.out));
        writer.beginObject() // throws IOException
                .name("name").value("张三")
                .name("age").value(24)
                .name("email").nullValue() //演示null
                .endObject(); // throws IOException
        writer.flush();
    }
}
