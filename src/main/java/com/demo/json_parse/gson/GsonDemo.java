package com.demo.json_parse.gson;

import com.google.gson.*;
import org.testng.annotations.Test;


/**
 *        <dependency>
 *             <groupId>com.google.code.gson</groupId>
 *             <artifactId>gson</artifactId>
 *             <version>2.8.5</version>
 *         </dependency>
 *
 * 　Gson提供了fromJson()和toJson() 两个直接用于解析和生成的方法，前者实现反序列化，后者实现了序列化。
 */
public class GsonDemo {

    /**
     * 基本数据类型的解析
     */
    @Test
    public void test(){
        Gson gson = new Gson();
        int i = gson.fromJson("100", int.class); //100
        double d = gson.fromJson("\"99.99\"", double.class);  //99.99
        boolean b = gson.fromJson("true", boolean.class);     // true
        String str = gson.fromJson("String", String.class);   // String
    }


    @Test
    public void test2(){
        Gson gson = new Gson();
        String jsonString = "{\"name\":\"张三\",\"age\":24}";
        Doctor doctor = gson.fromJson(jsonString, Doctor.class);
        System.out.println(doctor);
        Object o = gson.fromJson(jsonString, Object.class);
    }

    /**
     * 基本数据类型的生成　
     */
    @Test
    public void test3(){
        Gson gson = new Gson();
        int i=100;
        boolean b=false;
        String str="hello";
        String str2 = "{\"name\":\"张三\",\"age\":24}";
        String jsonNumber = gson.toJson(i);       // 100
        String jsonBoolean = gson.toJson(b);    // false
        String jsonString = gson.toJson(str); //"String"
        String jsonString2 = gson.toJson(str2);

        System.out.println(i);
        System.out.println(jsonNumber);
        System.out.println();

        System.out.println(b);
        System.out.println(jsonBoolean);
        System.out.println();

        System.out.println(str);
        System.out.println(jsonString);
        System.out.println();

        System.out.println(str2);
        System.out.println(jsonString2);

    }



    /**
     * Gson在序列化时候，默认会忽略字段为null的属性
     */
    @Test
    public void test4(){
        Gson gson = new Gson();
        Doctor doctor = new Doctor("张三",24,null);
        String jsonObject = gson.toJson(doctor); // Doctor{name='张三', age=24}
        System.out.println(jsonObject);//emailAddress字段是没有在json中出现的
    }


    /**
     * Gson在序列化时候，默认会忽略字段为null的属性
     */
    @Test
    public void test5(){
        Gson gson = new Gson();
        Doctor doctor = new Doctor("张三",24);
        String jsonObject = gson.toJson(doctor); // Doctor{name='张三', age=24}
        System.out.println(jsonObject);//emailAddress字段是没有在json中出现的
    }


    /**
     *  使用GsonBuilder导出null值、格式化输出、日期时间
     *  //test4(),test5()中email字段是没有在json中出现的，当在调试时需要导出完整的json串时或API接中要求没有值必须用Null时，GsonBuilder就会比较有用。
     */
    @Test
    public void test6(){
        Gson gson = new GsonBuilder().serializeNulls() .create();
        Doctor doctor = new Doctor("张三",24);
        String jsonObject = gson.toJson(doctor); //{"name":"张三","age":24,"emailAddress":null}
        System.out.println(jsonObject);
    }


    /**
     * 序列化
     */
    @Test
    public void test7(){
        Gson gson = new Gson();

        Stu stu = new Stu();
        stu.setAge(10);
        stu.setName("xm");
        stu.setSubjects(new String[]{"chinese","math"});
        String jsonString = gson.toJson(stu);

        //JsonObject jsonObject = parse.getAsJsonObject();
        //JsonPrimitive asJsonPrimitive = jsonObject.getAsJsonPrimitive("");
        //System.out.println(parse);
        /*JsonObject jsonObject1=new JsonObject();
        JsonObject jsonObject2=null;
        System.out.println(jsonObject1.isJsonNull());
        System.out.println(jsonObject1 == null);
        System.out.println(jsonObject1.toString());
*/
        // System.out.println(jsonObject2.isJsonNull());
        //System.out.println(jsonObject2 == null);

    }


    /**
     * 反序列化
     */
    @Test
    public void test8(){
        String jsonStr="{\n" +
                "               \"name\":\"ocean\",\n" +
                "               \"age\":28,\n" +
                "               \"score\":{\"chinese\":100,\"math\":120}\n" +
                "            }";

        Object o = new Gson().fromJson(jsonStr, Object.class);
        System.out.println(o);


    }

    /**
     * 异常
     */
    @Test
    public void test9(){
        System.out.println("======================================");
        String content = "[{\"userName\": \"admin\",\"password\": \"admin\"}, {\"userName\": \"admin2\",\"password\": \"admin2\"}]";
        Object jsonArray = new JsonParser().parse(content).getAsJsonObject();
        System.out.println(content);
        System.out.println(jsonArray);
    }


    @Test
    public void test10(){
        System.out.println("======================================");
        String content = "[{\"userName\": \"admin\",\"password\": \"admin\"}, {\"userName\": \"admin2\",\"password\": \"admin2\"}]";
        Object jsonArray = new JsonParser().parse(content).getAsJsonArray();
        System.out.println(content);
        System.out.println(jsonArray);
    }


}
class Doctor {

    public String name;
    public int age;
    public String emailAddress;


    public Doctor() {
    }

    public Doctor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Doctor(String name, int age, String emailAddress) {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

class Stu{
    String[] subjects;
    String name;
    int age;

    public Stu() {
    }

    public Stu(String[] subjects, String name, int age) {
        this.subjects = subjects;
        this.name = name;
        this.age = age;
    }


    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}