package com.demo.json_parse.gson;

import com.google.gson.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GsonDemo2 {


    @Test
    public void test(){
        Gson gson = new Gson();
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        System.out.println(Arrays.toString(strings));
        System.out.println(jsonArray);
        System.out.println(jsonArray.toString());
    }

    @Test
    public void test2(){
        String jsonString = "{\"name\":\"张三\",\"age\":24}";
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
    }

    @Test//[{"name":"ocean","age":30},{"name":"ocean2","age":31}]
    public void test3(){
        String jsonString = "{\"name\":\"ocean\",\"age\":30}";
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString);
        System.out.println(jsonElement);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        System.out.println(jsonObject);

        Gson gson =new Gson();
        Doctor doctor = gson.fromJson(jsonElement, Doctor.class);
        System.out.println(doctor);
    }

    @Test
    public void test4(){
        String jsonString = "[{\"name\":\"ocean\",\"age\":30},{\"name\":\"ocean2\",\"age\":31}]";
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString);
        JsonArray jsonArray = jsonElement.getAsJsonArray();

        Gson gson =new Gson();
        ArrayList<Doctor> list =new ArrayList<Doctor>();
        for (JsonElement element : jsonArray) {
            Doctor doctor = gson.fromJson(element, Doctor.class);
            list.add(doctor);
        }
        System.out.println(list);
    }

    @Test
    public void test5(){
        Gson gson = new Gson();
        String jsonString = "{\"name\":\"ocean\",\"age\":30}";
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();

        JsonElement jsonElement = jsonObject.get("name");
        String name = jsonElement.getAsString();
        System.out.println("name:sss"+name);

        JsonElement jsonElement2 = jsonObject.get("age");
        int age = jsonElement2.getAsInt();

        System.out.println("name="+name+",age="+age);
    }


      @Test
    public void test6(){
        Gson gson = new Gson();
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        System.out.println(Arrays.toString(strings));
    }


    /**
     *   JsonObject转成String
     */
    @Test
    public void test7(){
        Gson gson = new Gson();
        String jsonString = "{\"name\":\"ocean\",\"age\":30}";
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
       // String asString = jsonObject.getAsString();//JsonObject不能通过这种方式转成String
        String s = jsonObject.toString();
        System.out.println(s);
    }



    @Test
    public void test8(){
        JsonPrimitive jsonPrimitive=new JsonPrimitive(1);
        System.out.println(jsonPrimitive.toString());
    }

    @Test
    public void test9(){
        Gson gson = new Gson();
        String jsonString = "{\"name\":\"ocean\",\"age\":30}";
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        JsonPrimitive name = jsonObject.getAsJsonPrimitive("name");
        String asString = name.getAsString();
        System.out.println(name);
        System.out.println(asString);


        JsonArray asJsonArray = name.getAsJsonArray();
        System.out.println(asJsonArray);




        String jsonString2 = "{\"name\":\"ocean\",\"age\":30}";
        JsonObject jsonObject2 = new JsonParser().parse(jsonString2).getAsJsonObject();

        JsonElement jsonElement = jsonObject2.get("name");
        JsonArray asJsonArray1 = jsonElement.getAsJsonArray();

    }

}
