package com.demo.collectionandmap.map;

import org.testng.annotations.Test;

import java.util.*;

public class MapTest {
    /*
    * Map与Collection并列存在。用于保存具有映射关系的数据:Key-Value1
    * Map 中的 key 用Set来存放，不允许重复;value用Collection存放
     */
    public static void main(String[] args) {
        HashMap hm=new HashMap();
        hm.put("name","ocean");
        hm.put("age",28);
        hm.put("sex","girl");
        hm.put("sex","man");//后面覆盖前面

        //获取value values()
        System.out.print("map.values:");
        Collection c=hm.values();
        for (Object o : c) {
            System.out.print(o+" ");
        }

        //取key keySet()
        System.out.println();
        System.out.print("map.key:");
        Set s=hm.keySet();
        for (Object o : s) {
            System.out.print(o+" ");
        }


        //通过key获取value map.get(key)
        System.out.println();
       for(Object key:hm.keySet()){
           System.out.print(hm.get(key)+"\t");
       }


       //获取Map.Entry
        System.out.println("=============================");
        for (Object o: hm.entrySet()) {
            Map.Entry mp=(Map.Entry)o;
            System.out.println(mp.getKey() + "=" + mp.getValue());
        }

        System.out.println("***************************");
        HashMap<String,String> hm2=new HashMap();
        hm2.put("name","ocean");
        hm2.put("age","28");

        for (Map.Entry<String,String> entry: hm2.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }


        //lambda表达式
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        HashMap<Double,Double> hm3=new HashMap();
        hm3.put(123.0,789.1);
        hm3.put(456.2,000.1);
        hm3.forEach(((k,v)-> System.out.println(k+"----->"+v)));
        System.out.println();
        hm3.entrySet().forEach(entry-> System.out.println( entry.getKey()+"-->"+entry.getValue() ));
        System.out.println();
        hm3.entrySet().forEach(System.out::println);
    }


    //LinkedHashMap 是 HashMap 的子类,可以维护 Map 的迭代顺序：迭代顺序与 Key-Value1 对的插入顺序一致
    @Test
    public void test(){
        Map map=new LinkedHashMap();
        map.put("name","ocean");
        map.put("age","28");
        map.put("sex","man");
        map.forEach((k,v)-> System.out.println(k+"----->"+v));
    }


    //putAll() remove() clear()
    @Test
    public void test2(){
        Map map=new Hashtable();
        map.put("name","ocean");
        map.put("age","28");
        map.put("sex","man");

        System.out.println(map.containsKey("name"));//是否包含key
        System.out.println(map.containsValue("ocean"));//是否包含value

        System.out.println();
        System.out.println(map.size());//map键值对数量


        Map map2=new Hashtable();

        map2.putAll(map);  //添加map中的所有元素
        map2.forEach((k,v)-> System.out.println(k+"----->"+v));

        System.out.println();
        map2.remove("name");//所在的key-value
        map2.forEach((k,v)-> System.out.println(k+"----->"+v));

        System.out.println();
        map2.clear();  //清空
        System.out.println(map2.isEmpty());
    }






}
