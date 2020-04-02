package com.demo.json_parse.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.demo.json_parse.pojo.TestCaseRequestBody;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo1 {

       /*
           {
               "name":"ocean",
               "age":28,
               "score":{"chinese":100,"math":120}
            }
        */

    String jsonStr="{\n" +
            "               \"name\":\"ocean\",\n" +
            "               \"age\":28,\n" +
            "               \"score\":{\"chinese\":100,\"math\":120}\n" +
            "            }";


    //String转成JSONObject对象
    //JSONobject是FastJson提供的对象，实际就是一个map,只不过FastJson对其进行了封装，
    JSONObject jsonobj= JSON.parseObject(jsonStr);


    @Test
    public void test(){

        //打印字符串
        System.out.println(jsonStr);

        //打印JSONObject
        System.out.println("jsonobj: "+jsonobj);

        //JSONObject对象转成String
        String jsonStr2 = JSON.toJSONString(jsonobj);
        System.out.println("jsonStr2: "+jsonStr2);

        //将java对象赋值的字段转化成相应的json字符串
        TestCaseRequestBody t=new TestCaseRequestBody();
        t.setPackageName("mygroup");
        t.setClassName("MyJson");
        Map parameters=new HashMap<>();
        parameters.put("name","ocean");
        t.setParameters(parameters);
        String jsonString = JSON.toJSONString(t);
        System.out.println(jsonString);

        //没有赋值任何属性的对象会转成空串
        System.out.println();
        TestCaseRequestBody t2=new TestCaseRequestBody();
        String jsonString2 = JSON.toJSONString(t2);
        System.out.println(jsonString2);


    }



    //判断是否包含某个key
    @Test
    public void test2(){


        //判断是否包含某个key 方式1,不能判断多级路径
        System.out.println("containsKey方式==================");
        System.out.println(jsonobj.containsKey("score"));
        System.out.println(jsonobj.containsKey("score.chinese"));
        System.out.println(jsonobj.containsValue(28));//判断是否包含某个value

        //判断是否包含某个key 方式2,可判断多级路径
        System.out.println("JSONPath.contains方式==================");
        System.out.println(JSONPath.contains(jsonobj, "$.score"));
        System.out.println(JSONPath.contains(jsonobj, "$.score.chinese"));
    }


    //解析jsonobj指定path下的value
    @Test
    public void test3(){

        //JSONPath.eval 可解析多级路径
        System.out.println("JSONPath.eval=====================");
        String math= JSONPath.eval(jsonobj,"$.score.math").toString();
        System.out.println("math: "+math);


        //JSONPath.read 可解析多级路径
        System.out.println("JSONPath.read=====================");
        String math2 = JSONPath.read(jsonStr, "$.score.math").toString();
        System.out.println("math2: "+math2);

        //getString 不能解析多级路径
        System.out.println("getString=====================");
        System.out.println(jsonobj.getString("score"));
        System.out.println(jsonobj.getString("score.math"));


    }


    //更新jsonobj对应某个key的值
    @Test
    public void test4(){

        System.out.println(JSONPath.eval(jsonobj, "$.score.math"));
        JSONPath.set(jsonobj,"$.score.math",150);
        System.out.println((int) JSONPath.eval(jsonobj, "$.score.math"));


        jsonobj.put("sex","man");
        System.out.println("jsonStr after put:"+jsonobj);
    }


    //JSONobject是FastJson提供的对象，实际就是一个map, jsonobj.put
    @Test
    public void test5(){
        System.out.println(jsonobj);
        jsonobj.put("sex","man");
        jsonobj.put("book", Arrays.asList("think in java","springboot"));
        System.out.println(jsonobj);
    }




    //java.lang.ClassCastException: com.alibaba.fastjson.JSONArray cannot be cast to com.alibaba.fastjson.JSONObject
    //数组字符串不能转化为JSONObject对象
    @Test
    public void test6(){
        /*
        * [{"resourceId": 123},{"jarpath": "/a/b"}]
        * */

        String jsonStr="[{\"resourceId\": 123},{\"jarpath\": \"/a/b\"}]";
        JSONObject jsonobj= JSON.parseObject(jsonStr);
        System.out.println(jsonobj);
    }



    //数组字符串转化为JSONArray对象
    @Test
    public void test7(){
        /*
         * [{"resourceId": 123},{"jarpath": "/a/b"}]
         * */

        String jsonStr="[{\"resourceId\": 123},{\"jarpath\": \"/a/b\"}]";
        JSONArray jsonArray = JSON.parseArray(jsonStr);
        System.out.println(jsonStr);
    }


    /*
     将json字符串转成对应的实体类
   * T parseObject(String text, Class<T> clazz)
   * */
    @Test
    public void test8() {
        String jsonStr = "{\n" +
                "    \"className\" : \"ThroughputTest\",\n" +
                "    \"packageName\" : \"com.ericsson.msran.test.performance.tests\",\n" +
                "    \"methodName\" : \"testThroughput\",\n" +
                "    \"configurationData\" : \"1b60235f-8b23-4b0b-b6d6-a5939d0c9735\",\n" +
                "    \"parameters\" : {\n" +
                "      \"ueConfigurationId\" : \"commonRealUEConfig\",\n" +
                "      \"throughputParametersId\" : \"para\",\n" +
                "      \"testId\" : \"ThroughputTest\"\n" +
                "    },\n" +
                "    \"id\" : \"testcase\",\n" +
                "    \"name\" : \"ThroughputTest\"\n" +
                "  }";

        TestCaseRequestBody testCaseRequestBody = JSONObject.parseObject(jsonStr, TestCaseRequestBody.class);
        System.out.println(testCaseRequestBody.toString());
    }

    @Test
    public void test9(){
        Object parse = JSON.parse(jsonStr);
    }




}
