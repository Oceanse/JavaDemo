package com.demo.basicdemo.operator;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;


/**
 *   算术运算符: + - * / % ++ --
 *   ++ --是单目运算符，++或者--结束后，变量的值会自增或者自减1
 * */
public class Operator {




























    /*instanceof 用来测试一个对象是否为一个类的实例,用法为：
    * boolean result = obj instanceof Class
    * 其中 obj 为一个对象，Class 表示一个类或者一个接口，
    * 当 obj 为 Class 的对象，或者是其直接或间接子类，或者是其接口的实现类，结果result 都返回 true，否则返回false。
    *
    * */

    @Test
    public void test8_1(){

        int i=1;
        //System.out.println(i instanceof Integer); instanceof 运算符只能用作对象的判断，obj必须是引用数据类型

        System.out.println(null instanceof Object);// java对 instanceof 运算符的规定就是：如果 obj 为 null，那么将返回 false

        String name = "James";
        System.out.println(name instanceof String);// 由于 name 是 String 类型，所以返回true

        Collection c=new ArrayList();
        System.out.println(c instanceof ArrayList);
    }




}
