package com.demo.generic.demo4;

import org.testng.annotations.Test;

import java.util.*;

/**
 *
 */
public class TestGeneric2 {

    @Test
    public void test(){

        /*？通配符可以理解成一种特殊的类型实参，但是它的类型又不是确定的，可以把？看成所有类型的父类。
        List<A>,List<>B都是List<?>的子类*/
        List<Integer> list5= Arrays.asList(1,2,3);
        List<?> list6;
        list6=list5;
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


    public void test3x(List<?> list){

        //List<?> list2=new ArrayList<?>(); 不能通过 new ArrayList<?>() 的方法来创建一个新的 ArrayList 对象。因为编译器无法知道具体的类型是什么
        list=new ArrayList<Integer>();

        //list.add(1);  "?"不能添加元素，只能作为消费者

    }


    /**
     * 可以使用 "? extends 上界"来限制未知类型的范围
     * 当引入了上界之后，在使用类型的时候就可以使用上界类中定义的方法。比如访问 List<? extends Number> 的时候，就可以使用 Number 类的 intValue 等方法
     */
    @Test
    public void test3(){
        Set<? extends Number> set;  //<? extends ...>泛型上限, set包含的元素类型是 Number 及其子类
        Set<Float> set2=new HashSet<>();
        Set<Double> set3=new HashSet<>();
        set=set2;
        set=set3;
    }


    /**
     * 可以使用 "? super 下界"来限制未知类型的范围
     */
    @Test
    public void test4(){
        Set<? super Integer> set;  //<? super ...>泛型下限
        Set<Number> set2=new HashSet<>();
        Set<Object> set3=new HashSet<>();
        set=set2;
        set=set3;
    }
}
