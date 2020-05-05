package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Date;


/**
 * 全局变量(成员变量和静态变量)具有默认初始值
 * 局部变量没有默认初始值，必须显式初始化
 */
public class InitialValue {

    //全局变量(成员变量和静态变量)具有默认初始值
    byte b;//false
    short s ;//0
    int i;//0
    long l;//0L
    float f;//0.0F
    double d;//0.0
    boolean flag;//false
    char c;// /u0000  这种格式是一个char字符unicode码的写法;它只是看起来时空格，但是它与空格、空字符串、NULL和"null"都不同，所以无法找到能够描述它的符号

    Object o;
    Runnable r;
    String[] names;

    static int age;
    static Date date;


    @Test
    public void test(){
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(flag);
        System.out.println("b"+c+"d");


        System.out.println(o);
        System.out.println(r);
        System.out.println("arr="+Arrays.toString(names));

        System.out.println("age="+age);
        System.out.println("date="+date);
    }

    public void test2(){
        //int i; 局部变量必须要显式的初始化
        int i=1;
        if(i!=2){
            System.out.println("right");
        }

        //String str;局部变量必须要显式的初始化
        String str=null; //String str=null会对引用变量str(存在栈内存)赋值为null,但是不会开辟堆空间，str完成了初始化
        System.out.println(str);
    }
}
