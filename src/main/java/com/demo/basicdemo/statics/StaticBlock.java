package com.demo.basicdemo.statics;


/*
 * 静态代码块在类加载时被执行，且只执行一次
 * 一个类中可以有多个静态代码块，自上而下顺次执行
 * 通常在静态代码块完成一些预备工作，比如初始化连接池，解析
 * */
public class StaticBlock {

    private static String firstName;
    private static String lastName;

    public static void main(String[] args) {
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
