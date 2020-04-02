package com.demo.generic;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TestGeneric2 {

    @Test
    public void test(){

        //向上转型1
        Object o;
        String s="abc";
        o=s;

        //向上转型2
        Integer[] arr=new Integer[]{1,2,3};
        Number[] num;
        num=arr;


        //A是B的子类，List<A>不是List<B>的子类
        List<Integer> list= Arrays.asList(1,2,3);
        List<Number> list2;
        //list2=list;   list不是list2的父类

        //泛型相同时引用可以传递
        List<Integer> list3= Arrays.asList(1,2,3);
        List<Integer> list4;
        list4=list3;
        list4.add(345);


        /*？是类型实参，而不是类型形参 ！再直白点的意思就是，
        此处的？和Number、String、Integer一样都是一种实际的类型，
        可以把？看成所有类型的父类，是一种真实的类型。
        List<A>,List<>B都是List<?>的子类*/
        List<Integer> list5= Arrays.asList(1,2,3);
        List<?> list6;
        list6=list5;
        //list6.add(1);
        
    }
    
    public void printList(List<?> list){
        for (Object o : list) {
            System.out.print(o+" ");
        }
    }
    
    @Test
    public void test2(){
        List<Double> list=Arrays.asList(1.0,2.0);
        new TestGeneric2().printList(list);
    }

    @Test
    public void test3(){
        Set<? extends Number> set;  //<? extends ...>泛型上限
        Set<Float> set2=new HashSet<>();
        Set<Double> set3=new HashSet<>();
        set=set2;
        set=set3;
    }

    @Test
    public void test4(){
        Set<? super Integer> set;  //<? super ...>泛型下限
        Set<Number> set2=new HashSet<>();
        Set<Object> set3=new HashSet<>();
        set=set2;
        set=set3;
    }
}
