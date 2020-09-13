package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class Autoboxing_unboxing {

    /**
     *  拆箱和装箱就是基本类型和包装类之间的转换
     *         基本类型--->包装类
     *         int --> Integer
     *         byte --> Byte
     *         short --> Short
     *         long --> Long
     *         char --> Character
     *         float --> Float
     *         double --> double
     *         boolean --> Boolean
     */
    @Test
    public void test6(){

        //手动装箱
        Integer i = new Integer(100);
        Character character = new Character('p');

        //手动拆箱
        int j = i.intValue();
        char ch = character.charValue();
    }


    /**
     * 自动装箱和自动拆箱是JDK5.0的一个新特性
     */
    @Test
    public void test7(){

        Double dd = new Double(1.0);
        double m = dd;//自动拆箱  包装类对象自动转换成基本数据类型 本质上是，编译器编译时自动添加double m=dd.doubleValue()
        Double n = 1.1; //自动装箱  基本类型就自动地封装到与它相似类型的包装中 本质上是，编译器编译时自动添加：Double n =Double.valueOf(n);
    }


    /**
     * 自动装箱和自动拆箱是JDK5.0的一个新特性
     */
    @Test
    public void test7_2(){
        ArrayList<Double> doubles = new ArrayList<Double>();
        doubles.add(1.0);//Java编译器自动装箱:  doubles.add(new Double(1.0));

        Character character=new Character('c');
        char c='c';
        printChar(character);//自动拆箱
        printCharacter(c);//自动装箱
    }

    public static void printChar(char c) {
        System.out.println(c);
    }

    public static void printCharacter(Character c) {
        System.out.println(c);
    }
}
