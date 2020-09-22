package com.demo.basicdemo.code_block;


import org.testng.annotations.Test;

/**
 * 加载时机：
 * 静态代码块，它是随着类的加载而被执行，只要类被加载了就会执行，而且只会加载一次
 * 静态代码块在类加载时(加载.class文件)且在main方法和构造器之前被执行，且只执行一次
 *
 *
 * 用途：
 * 因为他会在main方法和构造方法之前被调用，所以通常在静态代码块完成一些预备工作(初始化静态数据成员)，比如初始化连接池，解析；
 *
 * 执行顺序：
 * 一个类中可以有多个静态代码块，自上而下顺次执行
 *
 * Note: 只能初始化静态数据成员
 *
 * 语法： static{ }
 * */
public class StaticBlock {

    private static String firstName;
    private static String lastName;

    public StaticBlock() {
        System.out.println("empty constructor");
    }


    static {
        System.out.println(firstName="Haiyang");
    }

    static {
        System.out.println(lastName="Pan");
    }







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


}
