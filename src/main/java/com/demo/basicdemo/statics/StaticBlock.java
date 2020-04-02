package com.demo.basicdemo.statics;


/*
 * java{...}
 * 静态代码块在类加载时被执行，且只执行一次
 * 一个类中可以有多个静态代码块，自上而下顺次执行
 * 通常在静态代码块完成一些预备工作，比如初始化连接池，解析
 * */
public class StaticBlock {


    public static void main(String[] args) {
        System.out.println(333);
    }

    static {
        System.out.println(111);
    }

    static {
        System.out.println(222);
    }
}
