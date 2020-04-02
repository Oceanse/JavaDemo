package com.demo.exception;


import org.testng.annotations.Test;

/**
 * finally
 *  finally block is a block that is used to execute important code such as closing connection, stream etc.
 *  Java finally block is always executed whether com.demo.exception is handled or not.
 *  Java finally block follows try or catch block.
 * Note: If you don't handle com.demo.exception, before terminating the program, JVM executes finally block(if any).
 */
public class FinallyDemo {


    /**
     * 没有异常
     * finally example where com.demo.exception doesn't occur.
     */
    @Test
    public void test() {
        try {
            int data = 25 / 5;
            System.out.println(data);
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }


    /**
     * Let's see the java finally example where com.demo.exception occurs and not handled.
     * 如果异常没有被处理,finally block 可以被执行，但是被执行后程序就此中断，finally block后面的代码不会执行
     */
    @Test
    public void test2() {
        try {
            int data = 25 / 0;//直接跳到finally block
            System.out.println(data);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("这里代码不会被执行");//如果异常没有被处理,finally block 可以被执行，但是被执行后程序就此中断，finally block后面的代码不会执行
    }


    /**
     * Let's see the java finally example where com.demo.exception occurs and not handled.
     * 如果异常没有被处理,finally block 可以被执行，但是被执行后程序就此中断，finally block后面的代码不会执行
     */
    @Test
    public void test2_2() {
        try {
            int data = 25 / 0;
            System.out.println(data);
        } catch (NullPointerException e) {//没有catch住
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("这里代码不会被执行");//如果异常没有被处理,finally block 可以被执行，但是被执行后程序就此中断，finally block后面的代码不会执行
    }


    /**
     * Let's see the java finally example where com.demo.exception occurs and handled.
     * 抛出异常，被catch处理掉，finally block及之后的代码都可以被执行
     */
    @Test
    public void test3() {
        try {
            int data = 25 / 0;
            System.out.println(data);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("这里可以被执行");//异常被catch住处理，这里可以被执行
    }


    @Test
    public void test4() {

    }




}
