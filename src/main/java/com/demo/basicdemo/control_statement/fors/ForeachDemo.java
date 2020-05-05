package com.demo.basicdemo.control_statement.fors;

import org.testng.annotations.Test;

import java.util.*;

/**
 * As of Java 5, the enhanced for loop was introduced and mainly used to traverse collection or arrays.
 *
 *
 *语法：
 * “类型”为集合元素的类型，“变量名”表示集合中的每一个元素，“集合”是被遍历的集合对象或数组
 * for(类型 变量名:集合) {
 *     语句块;
 * }
 *
 *
 * 特点：方便简单，不能修改数组或者集合的元素的值
 */
public class ForeachDemo {

    /**
     * for-each traverse array
     */
    @Test
    public void test() {

        int[] numbers = {10, 20, 30, 40, 50};
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(2 * numbers[i]+" ");
        }

        System.out.println();

        //n保存了集合中的元素，for-each 语句将集合中的元素一一取出来，并保存到n中,
        //无须获得数组长度，也无须根据索引来访问数组元素,for-each 语句在遍历集合的时候要简单方便得多。
        for (int n : numbers) {
            System.out.print(2 * n+" ");
        }
    }


    /**
     * for-each traverse List & Set
     */
    @Test
    public void test2() {

        List<String> fruits= Arrays.asList("apple","grape","orange","lemon");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        Set<String> books =new HashSet<>();
        books.add("Thinking in java");
        books.add("Linux");
        books.add("Spring cloud");
        for (String book : books) {
            System.out.println(book);
        }
    }

    /**
     * for-each traverse map
     */
    @Test
    public void test3(){
        Map<String,Integer> personInfo=new HashMap<>();
        personInfo.put("ocean",28);
        personInfo.put("dahuang",24);

        Set<String> names=personInfo.keySet();
        for (String name : names) {
            System.out.println("name: "+name+", age: "+personInfo.get(name));
        }
    }

    @Test
    public void test4(){
        List<String> fruits= Arrays.asList("apple","grape","orange","lemon");
        for (String fruit : fruits) {//这里的fruit只是一个存储元素的临时变量
            System.out.println(fruit.toUpperCase());
        }
        System.out.println(fruits);//List元素不会改变
    }
}
