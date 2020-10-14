package com.demo.generic.demo4;

import org.testng.annotations.Test;

import java.util.*;

/**
 *
 */
public class TestGeneric {

    @Test
    public void test(){

        //向上转型1
        Object o;
        String s="abc";
        o=s;

        // 向上转型2
        // 在Java语言中，数组是协变的, 如果 Number是 Integer 的超类型，那么 Number[] 也是 Integer[]的超类型
        Integer[] arr=new Integer[]{1,2,3};
        Number[] num;
        num=arr;

        //A是B的子类，List<A>不是List<B>的子类,这么做将破坏要提供的类型安全泛型;
        List<Integer> list= Arrays.asList(1,2,3);
        List<Number> list2;
        //list2=list;   list不是list2的父类


        //泛型相同时引用可以传递
        List<Integer> list3= Arrays.asList(1,2,3);
        List<Integer> list4;
        list4=list3;
        list4.add(345);

}}
