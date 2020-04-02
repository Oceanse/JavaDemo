package com.demo.json_parse.orgjson;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrgJson {



    //json字符串转成JSONObject
    @Test
    public void test(){
        String jsonStr="{\n" +
                "\"name\":\"ocean\",\n" +
                "\"age\":28\n" +
                "}";
        JSONObject jsonObject=new JSONObject(jsonStr);
        System.out.println(jsonObject);

        //JSONObject本质是一个map
        System.out.println();
        jsonObject.put("sex","man");
        System.out.println(jsonObject);

        //解析数据
        System.out.println();
        Object sex = jsonObject.get("sex");
        System.out.println(sex);
    }




    //通过map构造JSONObject
    @Test
    public void test2(){
        Map map=new HashMap();
        map.put("name","ocean");
        map.put("age",28);

        List hobby=new ArrayList();
        hobby.add("footbal");
        hobby.add("sing");
        hobby.add("programing");
        map.put("hobby",hobby);

        Map parent=new HashMap();
        parent.put("father","zhanaopan");
        parent.put("mother","xiuzhenma");
        map.put("parent",parent);

        JSONObject jsonObject=new JSONObject(map);
        System.out.println(jsonObject);

        System.out.println();
        System.out.println(jsonObject.get("parent"));
    }




    //构造JSONArray
    @Test
    public void test3(){
        /*
         {
            "name": "ocean",
            "age": 28,
            "hobby": ["sing","code"]
         }
    */


        String jsonStr="  {\n" +
                "        \"name\": \"ocean\",\n" +
                "        \"age\": 28,\n" +
                "        \"hobby\": [\"sing\",\"code\"]\n" +
                "    }";
        JSONObject jsonObject=new JSONObject(jsonStr);


        //直接获取JSONArray
        System.out.println();
        JSONArray hobby1 = jsonObject.getJSONArray("hobby");
        System.out.println(hobby1);


        //间接获取JSONArray
        System.out.println();
        Object hobby = jsonObject.get("hobby");
        System.out.println(hobby);
        if(hobby instanceof JSONArray){
           System.out.println("hobby instanceof JSONArray");
           JSONArray jsonArray =(JSONArray)hobby;
       }


       //这里的sex不是JSONArray
        Object sex = jsonObject.get("name");
        System.out.println(sex);
        System.out.println(sex instanceof JSONArray);
    }

    /*
  * [{
      "name": "ocean",
      "age": 30
  },
  {
      "name": "ocean2",
      "age": 31
  }
]
  * */
    @Test
    public void test3_2(){

        String str="[{\n" +
                "\t\t\"name\": \"ocean\",\n" +
                "\t\t\"age\": 30\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"name\": \"ocean2\",\n" +
                "\t\t\"age\": 31\n" +
                "\t}\n" +
                "]";
        JSONArray jsonArray=new JSONArray(str);
        for(Object o:jsonArray){

            System.out.println(o);
        }
    }


    //遍历JSONArray
    @Test
    public void test4(){
        String jsonStr="  {\n" +
                "        \"name\": \"ocean\",\n" +
                "        \"age\": 28,\n" +
                "        \"hobby\": [\"sing\",\"code\"]\n" +
                "    }";
        JSONObject jsonObject=new JSONObject(jsonStr);
        JSONArray hobby = jsonObject.getJSONArray("hobby");

        //增强for循环
        for (Object o : hobby) {
            System.out.print(o+"\t");
        }


        /*fori遍历
        for (int i = 0; i < hobby.length(); i++) {
            System.out.print(hobby.getJSONObject(i)+"\t");//hobby的每个元素都是String,所以不能用hobby.getJSONObject(i)
        }*/
    }




    @Test
    public void test5(){
        /*
        * {
	        "name": "ocean",
	        "age": 28,
	        "hobby": [{"sports": "basketball"},
	                  {"fruit": "apple"}]
          }
        * */

        String jsonStr="{\n" +
                "\t        \"name\": \"ocean\",\n" +
                "\t        \"age\": 28,\n" +
                "\t        \"hobby\": [{\"sports\": \"basketball\"},\n" +
                "\t                  {\"fruit\": \"apple\"}]\n" +
                "          }";
        JSONObject jsonObject=new JSONObject(jsonStr);
        JSONArray hobby = jsonObject.getJSONArray("hobby");
        for (int i = 0; i < hobby.length(); i++) {
            System.out.println(hobby.getJSONObject(i));
        }

        //返回的每个元素都是JSONObject
        System.out.println();
        JSONObject jsonObject1 = hobby.getJSONObject(0);
        JSONObject jsonObject2 = hobby.getJSONObject(1);

    }


    /**
     * optString/optInt类似于getString/getInt
     * optString/optInt会在得不到你想要的值时候返回空字符串“ ”或指定的默认值
     * optString/optInt可以解决服务器字段缺少或者没有该字段而导致的异常以至于程序崩溃
     */
    @Test
    public void test6(){
        String jsonStr="{\n" +
                "\"name\":\"ocean\",\n" +
                "\"age\":28\n" +
                "}";

        JSONObject jsonObject=new JSONObject(jsonStr);
        String name = jsonObject.optString("name");
        System.out.println("name:"+name);

        String sex = jsonObject.optString("sex");
        System.out.println("sex:"+sex);

        String sex2 = jsonObject.optString("sex","man");//sex字段不存在时候指定默认值
        System.out.println("sex2:"+sex2);

        int age = jsonObject.optInt("age");
        System.out.println("sex2:"+age);

    }


    /**
     * getString在得不到你想要的值时候会抛出异常
     */
    @Test
    public void test7(){
        String jsonStr="{\n" +
                "\"name\":\"ocean\",\n" +
                "\"age\":28\n" +
                "}";

        JSONObject jsonObject=new JSONObject(jsonStr);

        System.out.println(jsonObject.getString("name"));
        System.out.println(jsonObject.getInt("age"));

        String name = jsonObject.getString("names");
        System.out.println("names:"+name);

    }


}
