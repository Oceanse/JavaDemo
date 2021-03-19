package com.demo.basicdemo.control_statement.loop.fors;

import com.demo.basicdemo.code_block.construct_block.demo1.Person;
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


    /**
     * for(类型 变量名:集合)
     * 这里变量名可以理解为集合元素的副本，所以通过变量名操作元素不会影响原集合中元素的变量值(字面值或者地址)
     */
    @Test
    public void test4(){
        List<String> fruits= Arrays.asList("apple","grape","orange","lemon");
        for (String fruit : fruits) {//这里的fruit只是一个存储元素的临时变量
            System.out.println(fruit.toUpperCase());
        }
        System.out.println(fruits);//List元素不会改变
    }

    /**
     * for(类型 变量名:集合)
     * 这里变量名可以理解为集合元素的副本，所以通过变量名操作元素不会影响原集合中元素的变量值(字面值或者地址)
     */
    @Test
    public void test5(){
        Person p1=new Person("ocean",31);
        Person p2=new Person("phy",32);

        //personList存放的是对象的内存地址
        List<Person> personList=Arrays.asList(p1,p2);
        System.out.println(personList);//[com.demo.basicdemo.code_block.construct_block.demo1.Person@2b9627bc, com.demo.basicdemo.code_block.construct_block.demo1.Person@65e2dbf3]
        for (Person person : personList) {
            person =new Person();//这里不会改变原List中的变量值(对象地址)
        }
        System.out.println(personList);//[com.demo.basicdemo.code_block.construct_block.demo1.Person@2b9627bc, com.demo.basicdemo.code_block.construct_block.demo1.Person@65e2dbf3]
    }



    /**
     * for(类型 变量名:集合)
     * 这里变量名可以理解为集合元素的副本，所以通过变量名操作元素不会影响原集合中元素的变量值(字面值或者地址)
     */
    @Test
    public void test6(){
        Person p1=new Person("ocean",31);
        Person p2=new Person("phy",32);

        //personList存放的是对象的内存地址
        List<Person> personList=Arrays.asList(p1,p2);
        System.out.println(personList.get(0).getName());
        System.out.println(personList.get(1).getName());
        for (Person person : personList) {
            //这里不会改变原List中的变量值(对象地址)，但是这里的person也会指向原列表元素所指向的对象，相当于一个对象又多了一个句柄，所以这里原列表元素所指向的对象的内容会发生变化
            person.setName("Panhai Yang");
        }
        System.out.println(personList.get(0).getName());
        System.out.println(personList.get(1).getName());
    }



}
