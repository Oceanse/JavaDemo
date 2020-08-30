package com.demo.json_parse.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.demo.json_parse.pojo.CaseBody;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo1 {


    String jsonStr = "{\n" +
            "               \"name\":\"ocean\",\n" +
            "               \"age\":28,\n" +
            "               \"score\":{\"chinese\":100,\"math\":120}\n" +
            "            }";


    //String转成JSONObject对象
    //JSONobject是FastJson提供的对象，实际就是一个map,只不过FastJson对其进行了封装，
    JSONObject jsonobj = JSON.parseObject(jsonStr);


    /**
     * 序列化和反序列化
     * JSONObject是FastJson提供的对象，实际就是一个map,只不过map对其进行了封装，
     */
    @Test
    public void test() {

        String jsonStr = "{\n" +
                "               \"name\":\"ocean\",\n" +
                "               \"age\":28,\n" +
                "               \"score\":{\"chinese\":100,\"math\":120}\n" +
                "            }";


        //String转成JSONObject对象
        JSONObject jsonobj = JSON.parseObject(jsonStr);

        //JSONObject对象转成String
        String str = JSON.toJSONString(jsonobj);// 或者String str = jsonobj.toJSONString();

        System.out.println("jsonobj: " + jsonobj);
        System.out.println("str: " + str);
    }




    /**
     * java对象序列化
     * 若java对象的属性没有赋值，转化后的json字符串中将不包含对应的key
     */
    @Test
    public void test2() {

        //将java对象赋值的字段转化成相应的json字符串
        CaseBody c = new CaseBody();
        c.setPackageName("mygroup");
        c.setClassName("Myclass");
        c.setMethodName("mymethod");
        Map parameters = new HashMap<>();
        parameters.put("name", "ocean");
        c.setParameters(parameters);
        String jsonString = JSON.toJSONString(c);
        System.out.println("jsonString: " + jsonString);

        //没有赋值任何属性的对象会转成空串
        System.out.println();
        CaseBody t2 = new CaseBody();
        String jsonString2 = JSON.toJSONString(t2);
        System.out.println("jsonString2 " + jsonString2);
    }




    /**
     * 反序列化
     * 数组字符串不能转化为JSONObject对象
     * java.lang.ClassCastException: com.alibaba.fastjson.JSONArray cannot be cast to com.alibaba.fastjson.JSONObject
     */
    @Test
    public void test3() {

        // [{"resourceId": 123},{"name": "testjar"}]
        String jsonStr = "[{\"resourceId\": 123},{\"name\": \"testjar\"}]";
        JSONObject jsonobj = JSON.parseObject(jsonStr);
        System.out.println(jsonobj);
    }


    /**
     * 反序列化
     * 数组字符串转化为JSONArray对象
     */
    @Test
    public void test3_2() {

        //[{"resourceId": 123},{"name": "testjar"}]
        String jsonStr = "[{\"resourceId\": 123},{\"name\": \"testjar\"}]";
        JSONArray jsonArray = JSON.parseArray(jsonStr);
        System.out.println(jsonStr);
    }

    /**
     * java对象反序列化
     * json相对java bean中多余的属性没有任何影响，缺少的属性对应的java对象的属性值是默认值
     */
    @Test
    public void test3_3() {

        String jsonStr = "{\n" +
                "    \"className\" : \"ThroughputTest\",\n" +
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

        CaseBody testCaseRequestBody = JSONObject.parseObject(jsonStr, CaseBody.class);
        System.out.println(testCaseRequestBody.toString());
    }






    /**
     *  读
     *  解析jsonobj指定path下的value
     */
    @Test
    public void test4() {

        //JSONPath.eval 可解析多级路径
        System.out.println("JSONPath.eval=====================");
        String math = JSONPath.eval(jsonobj, "$.score.math").toString();
        System.out.println("math: " + math);


        //JSONPath.read 可解析多级路径
        System.out.println();
        System.out.println("JSONPath.read=====================");
        String math2 = JSONPath.read(jsonStr, "$.score.math").toString();
        System.out.println("math2: " + math2);

        //getString 不能解析多级路径
        System.out.println();
        System.out.println("getString=====================");
        System.out.println(jsonobj.getString("score"));
        System.out.println(jsonobj.getString("score.math"));
    }


    /**
     * 改
     * JSONobject是FastJson提供的对象，实际就是一个map
     * 通过put更新jsonobj对应某个key的值
     */
    @Test
    public void test5() {

        //JSONPath.read对任意路径keypath下的值进行设置
        System.out.println(JSONPath.eval(jsonobj, "$.score.math"));
        JSONPath.set(jsonobj, "$.score.math", 150);
        System.out.println(JSONPath.eval(jsonobj, "$.score.math"));


    }


    /**
     * 增
     * JSONobject是FastJson提供的对象，实际就是一个map
     * 可通过put方法对json增加键值对
     */
    @Test
    public void test6() {
        System.out.println(jsonobj);
        jsonobj.put("sex", "man");
        jsonobj.put("book", Arrays.asList("think in java", "springboot"));
        System.out.println(jsonobj);
        System.out.println(JSON.toJSONString(jsonobj));
    }




    /**
     * 反序列化后判断json是否包含某个key: 转成JSONObject后进行判断
     * $表示根元素
     */
    @Test
    public void test7() {
        //方式1,不能判断多级路径
        System.out.println("containsKey方式==================");
        System.out.println(jsonobj.containsKey("score"));
        System.out.println(jsonobj.containsKey("score.chinese"));

        //方式2,可判断多级路径
        System.out.println();
        System.out.println("JSONPath.contains方式==================");
        System.out.println(JSONPath.contains(jsonobj, "$.score"));
        System.out.println(JSONPath.contains(jsonobj, "$.score.chinese"));
    }
}


