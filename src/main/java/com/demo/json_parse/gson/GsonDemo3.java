package com.demo.json_parse.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.Test;

public class GsonDemo3 {

    @Test
    public void test(){
        Gson gson = new Gson();
        String jsonString = "{\"name\":\"ocean\",\"age\":30}";
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        jsonObject.addProperty("sex","man");
        System.out.println(jsonObject);
        System.out.println(jsonObject.toString());
    }



    @Test
    public void test2(){
        Gson gson = new Gson();
        String jsonString = "{\"name\":\"ocean\",\"age\":30}";
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();


        JsonElement name = jsonObject.get("name");
        String n = name.toString();
        jsonObject.addProperty("engname",n);
        System.out.println(jsonObject);


    }
}
