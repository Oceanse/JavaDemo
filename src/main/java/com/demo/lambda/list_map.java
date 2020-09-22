package com.demo.lambda;

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
    public void test() {
        //List<Integer> ls= Arrays.asList(1,2,3);
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(5);
        ls.add(2);
        ls.add(2);
        ls.add(2);
        ls.add(7);
        ls.add(4);

        ls.forEach(x -> System.out.print(x + " "));

        System.out.println();
        ls.forEach(System.out::print);

        System.out.print('\n');
        ls.forEach(n ->
        {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
        });

    }


    //Stream是java8中新增加的一个特性,被java猿统称为流
    @Test
    public void test2() {
        //List<Integer> ls= Arrays.asList(1,2,3);
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(5);
        ls.add(2);
        ls.add(2);
        ls.add(2);
        ls.add(7);
        ls.add(4);

        List ls2 = ls.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(ls2);

        List ls3 = ls.stream().limit(2).collect(Collectors.toList());
        System.out.println(ls3);

        List ls4 = ls.stream().sorted().collect(Collectors.toList());
        System.out.println(ls4);

        System.out.println("1===========================");
        List<Integer> ls5 = ls.stream().map(i -> i * i).collect(Collectors.toList());//表达式不用{}
        List<Integer> ls55 = ls.stream().map(i -> {
            return i * i;          //语句用{}，必须有返回值
        }).collect(Collectors.toList());
        List<Integer> ls555 = ls.stream().map(i -> {
            int m = i * i;
            return m;     //语句用{}，必须有返回值
        }).collect(Collectors.toList());//语句用{}

        List ls5555 = ls.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(ls5);
        System.out.println(ls55);
        System.out.println(ls555);
        System.out.println(ls5555);


        /*Stream 可以并行化操作，迭代器只能命令式地、串行化操作。顾名思义，
        当使用串行方式去遍历时，每个 item 读完后再读下一个 item。而使用并行去遍历时，
        数据会被分成多个段，其中每一个都在不同的线程中处理，然后将结果一起输出,
        Stream 的并行操作依赖于 Java7 中引入的 Fork/Join 框架（JSR166y）来拆分任务和加速处理过程
        parallelStream其实就是一个并行执行的流.它通过默认的ForkJoinPool,可能提高你的多线程任务的速度*/
        List ls6 = ls.parallelStream().map(i -> 2 * i).collect(Collectors.toList());

        System.out.println("2===========================");
        List<Integer> ls7 = new ArrayList<>();
        ls7.add(1);
        ls7.add(2);
        ls7.add(3);
        ls7.add(4);
        ls7.stream().forEach(ele -> System.out.print(ele + " "));//输出顺序是固定的
        System.out.println();
        ls7.parallelStream().forEach(ele -> System.out.print(ele + " "));//并行流遍历造成输出结果顺序是随机的

        //如果平行处理时，希望最后顺序是按照原来Stream的数据顺序，那可以调用forEachOrdered()
        System.out.println();
        ls7.parallelStream().forEachOrdered(ele -> System.out.print(ele + " "));
    }


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
