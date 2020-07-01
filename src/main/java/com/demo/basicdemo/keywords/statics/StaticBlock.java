package com.demo.basicdemo.keywords.statics;


import org.testng.annotations.Test;

/**
 * 静态代码块在类加载时(加载.class文件)且main方法之前被执行，且只执行一次
 *
 * 通常在静态代码块完成一些预备工作(初始化静态数据成员)，比如初始化连接池，解析；
 *
 * 一个类中可以有多个静态代码块，自上而下顺次执行
 *
 * Note: 只能初始化静态数据成员
 *
 * 语法： static{ }
 * */
public class StaticBlock {

    private static String firstName;
    private static String lastName;

    public static void main(String[] args) {
        System.out.println("firstName="+firstName);
        System.out.println("lastName="+lastName);
    }

    @Test
    public void test(){
        new StaticBlock();
        new StaticBlock();

        System.out.println("firstName="+firstName);
        System.out.println("lastName="+lastName);
    }

    static {
        System.out.println(firstName="Haiyang");
    }

    static {
        System.out.println(lastName="Pan");
    }
}