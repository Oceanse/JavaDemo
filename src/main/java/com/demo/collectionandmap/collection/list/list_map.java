package com.demo.collectionandmap.collection.list;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class list_map {





    @Test
    public void test3() {

        List<String> s = Arrays.asList("aa", "bb");
        List ls = s.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls);

        System.out.println(s.stream().collect(Collectors.toSet()));

    }


    @Test
    public void test4() {

        HashMap<String, String> hm = new HashMap();
        hm.put("name", "ocean");
        hm.put("sex", "man");

        hm.forEach((k, v) -> System.out.println(k + "-->" + v));

        System.out.println();
        hm.forEach((k, v) ->
        {
            if (v.equals("ocean")) {
                System.out.println("hello" + " " + v);
            }
        });

        System.out.println();
        hm.entrySet().forEach(entry -> System.out.println(entry.getKey() + "-->" + entry.getValue()));

        System.out.println();
        hm.entrySet().forEach(System.out::println);

    }

    @Test
    public void test5() {

           /*{
                "result":{
             "oceans":{
                 "name":"ocean",
                 "age":28,
                 "score":{"chinese":100,"math":120}
             },
              "huang":{
                 "name":"dahuang",
                 "age":24,
                 "score":{"chinese":120,"math":100}
             }
                }

            }*/


        String jsonStr = "{\n" +
                "                \"result\":{\n" +
                "             \"oceans\":{\n" +
                "                 \"name\":\"ocean\",\n" +
                "                 \"age\":28,\n" +
                "                 \"score\":{\"chinese\":100,\"math\":120}\n" +
                "             },\n" +
                "              \"huang\":{\n" +
                "                 \"name\":\"dahuang\",\n" +
                "                 \"age\":24,\n" +
                "                 \"score\":{\"chinese\":120,\"math\":100}\n" +
                "             }\n" +
                "                }\n" +
                "\n" +
                "            }";


        String resultStr = JSONPath.eval(JSON.parseObject(jsonStr), "$.result").toString();
        System.out.println("1==================");
        System.out.println(resultStr);

        /*resultStr:
            {
             "oceans":{
                 "name":"ocean",
                 "age":28,
                 "score":{"chinese":100,"math":120}
             },
              "huang":{
                 "name":"dahuang",
                 "age":24,
                 "score":{"chinese":120,"math":100}
             }
                }*/

        System.out.println("2==================");
        JSONObject jsonobj = JSON.parseObject(resultStr);
        jsonobj.entrySet().forEach(entry -> System.out.println(entry));

        System.out.println("3==================");
        jsonobj.entrySet().forEach(entry -> System.out.println(entry.getValue().toString()));

        System.out.println("4==================");
        String s = jsonobj.entrySet().stream()
                .filter(entry -> JSONObject
                        .parseObject(entry.getValue().toString())
                        .getString("name").equals("ocean"))
                .findAny().map(entry -> entry.getKey()).orElse("");
        System.out.println(s);

    }


    /**
     * anyMatch，allMatch，noneMatch
     * anyMatch流中存在一个元素满足指定的条件那么返回true
     * allMatch流中所有元素满足指定的条件那么返回true
     * noneMatch流中所有元素都不满足指定的条件那么返回true
     */

    @Test
    public void test6() {

        List<String> strs = Arrays.asList("a", "a", "c", "a", "b");
        boolean aa = strs.stream().anyMatch(str -> str.equals("a"));
        boolean bb = strs.stream().allMatch(str -> str.equals("a"));
        boolean cc = strs.stream().noneMatch(str -> str.equals("a"));
        boolean dd = strs.stream().noneMatch(str -> str.equals("e"));
        long count = strs.stream().filter(str -> str.equals("a")).count();//返回满足筛选条件的元素的数量
        System.out.println(aa);// TRUE
        System.out.println(bb);// FALSE
        System.out.println(cc);// FALSE
        System.out.println(dd);// TRUE
        System.out.println(count);

    }


    /**
     * list.size=0 恒为true
     *
     */
    @Test
    public void test7() {
        ArrayList list=new ArrayList();
        System.out.println(list.stream().allMatch(item -> "".equals(item)));
    }



}
