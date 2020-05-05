package com.demo.basicdemo.variable;

import org.testng.annotations.Test;

/*
* out就是System里面的一个静态数据成员，而且这个成员是java.io.PrintStream类的引用
* */
public class PrintDemo {
    @Test
    public void test(){
        System.out.println(1);//println(int x)
        System.out.println(1.1);//println(double x)
        System.out.println(1.1f);//println(float x)
        System.out.println('A');//println(char x)
        System.out.println(true);//println(boolean x)
    }

    @Test
    public void test2(){
        System.out.println(1);//println(int x)
        System.out.println(1.1);//println(double x)
        System.out.println(1.1f);//println(float x)
        System.out.println('A');//println(char x)
        System.out.println(true);//println(boolean x)
    }
}
