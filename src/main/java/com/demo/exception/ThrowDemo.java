package com.demo.exception;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * throw主要用来显示的抛出自定义异常
 * The Java throw keyword is used to explicitly throw an com.demo.exception.
 * The throw keyword is mainly used to throw custom com.demo.exception.
 */
public class ThrowDemo {


    /**
     * 手动抛出异常不处理，那么程序会提前结束
     */
    @Test
    public void test() {
        int m = 0;
        if (m == 0) {
            //手动抛出异常，一般是在代码块的内部，当程序出现某种逻辑错误时由程序员主动抛出某种特定类型的异常
            //这里抛出运行时异常，可以不显示进行处理,java运行时系统默认处理方式是打印该异常对象包含的信息
            throw new ArithmeticException();//这里可以手动抛出自己想要的任何异常；后面不能跟代码；抛出异常之后整个方法的调用就结束了。
            //System.out.println("sss");
        }
        System.out.println("result="+1/0);//如果if语句块中抛出异常，那么程序会提前结束，这里不能被执行
    }



    @Test
    public void test1_2() {
        System.out.println("===========before");
        new ThrowDemo().test();//test方法会产生异常没有被处理，程序在test中就会提前结束，后面不能被执行
        System.out.println("===========after");
    }



    /**
     * 一定条件下，手动抛出异常没有实现，相当于没发生异常
     */
    @Test
    public void test2() {
        int m = 1;
        if (m == 0) {//if block不会被执行
            throw new ArrayIndexOutOfBoundsException();//这里可以手动抛出自己想要的任何异常；后面不能跟代码；抛出异常之后整个方法的调用就结束了。
        }
        System.out.println("m！=0,这里能被执行。。。");//如果if语句块中抛出异常，那么程序会提前结束，这里不能被执行
    }




    @Test
    public void test2_2() {
        System.out.println("===========before");
        new ThrowDemo().test2();//test2方法没有产生异常
        System.out.println("===========after");
    }




    /**
     * 手动抛出异常但是处理，程序会正常往下进行
     */
    @Test
    public void test3() {
        int m = 0;
        try {
            if (m == 0) {
                throw new ArithmeticException();//对象抛出的异常catch处理
            }
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("这里可以被执行");//即使m=0,也会被执行
    }



    /**
     * 被调用的方法抛出异常被处理后，程序会正常往下进行
     */
    @Test
    public void test3_2() {
        System.out.println("===========before");
        new ThrowDemo().test3();//test3中异常被处理掉，后面可以正常运行
        System.out.println("===========after");//test3抛出异常后有被处理，所以这里可以执行
    }


    /**
     * catch中抛出异常，相当于整个try-catch抛出了一个没被处理的异常对象
     */
    @Test
    public void test4() {
        int m = 0;
        try {
            if (m == 0) {
                throw new ArithmeticException();//手动抛出异常对象
            }
        } catch (Exception e) {
            throw new ArithmeticException();//catch中又抛出异常对象，相当于整个try-catch抛出了一个没被处理的异常对象，所以后面的代码不能运行
        }
        System.out.println("这里不可以被执行");
    }



    /**
     * 抛出编译时异常，不处理编译不通过，可以try-catch处理
     */
    @Test
    public void test5() {
        File file=new File("/a.txt");
        if (!file.exists()) {
            //这里抛出编译时异常，不处理编译不通过，可以try-catch处理
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("这里可以被执行");
    }




    /**
     * 抛出编译时异常，不处理编译不通过，可以throws处理
     */
    @Test
    public void test5_2() throws IOException {
        File file=new File("/a.txt");

        if (!file.exists()) {
            //这里抛出编译时异常，不处理编译不通过，可以throws,交给方法调用者处理
            throw new FileNotFoundException();//程序执行到这里的话会打印异常，并把异常throws出去，程序到此结束，后面不会被执行
        }
        System.out.println("sdfgdfg");
    }


    @Test
    public void test5_3() throws IOException {
    }


}
