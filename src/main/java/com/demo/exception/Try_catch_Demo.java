package com.demo.exception;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * The core advantage of com.demo.exception handling is to maintain the normal flow of the application.
 * An com.demo.exception normally disrupts the normal flow of the application that is why we use com.demo.exception handling. Let's take a scenario:
 * <p>
 * statement 1;
 * statement 2;
 * statement 3;  //com.demo.exception occurs
 * statement 4;
 * statement 5;
 * statement 6;
 * <p>
 * If we perform com.demo.exception handling, the rest of the statement will be executed. That is why we use com.demo.exception handling in Java.
 *
 *
 */
public class Try_catch_Demo {


    /**
     * 程序抛出异常而没有被处理会导致程序提前结束，从而使得后面的代码不能被执行
     */
    @Test
    public void test() {

        //throw com.demo.exception
        int data = 50 / 0;

        // The rest of the code is not executed; There can be 100 lines of code after com.demo.exception. So all the code after com.demo.exception will not be executed.
        System.out.println("rest of the code");
    }


    /**
     * 程序抛出异常而没有被处理会导致程序提前结束，从而使得后面的代码不能被执行
     */
    @Test
    public void test1_1() {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));

        int re = array[0] / 0;  //系统自动抛出一个内置异常对象给运行时系统，并且打印该对象的信息
        System.out.println("不能被执行。。。");
    }


    /**
     * 程序抛出的异常没有被catch住，相当于没有catch导致程序提前结束, 从而使得catch后面的代码不能被执行
     */
    @Test
    public void test1_2() {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));

        try {
            int re = array[0] / 0;  //系统自动抛出一个内置异常
        } catch (NullPointerException e) {//上面的异常对象不属于catch声明的异常类，该对象不能被捕获，相当于没有catch,所有catch后面的代码不能被执行
            e.printStackTrace();
        }

        System.out.println("异常没被捕获，所以这里不能被执行。。。");
    }


    /**
     * 抛出的异常被catch住并处理，catch后面的代码正常运行
     */
    @Test
    public void test2() {
        try {
            int data = 50 / 0; //may throw com.demo.exception
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code");
    }


    /**
     * 抛出的异常被catch住并处理，catch后面的代码正常运行
     */
    @Test
    public void test2_1() {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));

        try {
            int re = array[0] / 0;  //系统自动抛出一个内置异常
        } catch (ArithmeticException e) {//上面的异常对象一旦属于catch声明的异常类，该对象就会被捕获
            e.printStackTrace();//e.printStackTrace(); 使用这个方法打印出来的是所有出错的信息，包括了使用getMessage()方法打印出来的信息
        }

        System.out.println("catch后面可以被执行。。。");
    }


    /**
     * 使用异常类对象的父类也能够捕获到该异常
     * 抛出的异常被catch住并处理，catch后面的代码正常运行
     */
    @Test
    public void test2_2() {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));

        try {
            int re = array[0] / 0;
        } catch (RuntimeException e) {//使用异常类对象的父类也能够捕获到该异常，因为异常对象也是异常类父类的对象
            e.printStackTrace();
        }

        System.out.println("catch后面可以被执行。。。");
    }


    /**
     * displaying the custom message
     */
    @Test
    public void test2_3() {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));

        try {
            int re = array[0] / 0;
        } catch (ArithmeticException e) {
            System.out.println("Can't divided by zero");// displaying the custom message
        }

        System.out.println("catch后面可以被执行。。。");
    }


    /**
     * try中的code block 执行到中间时候抛出异常，直接跳转到catch，若异常被catch住并处理，catch后面的代码正常运行
     * try中的code block剩余的代码肯定不能再被执行
     * 整体上呈现一种跳跃执行的感觉
     */
    @Test
    public void test2_4() {
        try {
            int data = 50 / 0; //这里抛出异常之后直接跳转到catch，若异常被catch住并处理，catch后面的代码正常运行
            System.out.println("这里不能被执行。。。");
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        System.out.println("catch后面可以被执行。。。");
    }


    /**
     * 程序抛出的异常没有被catch住，相当于没有catch导致程序提前结束
     */
    @Test
    public void test2_5() {
        try {
            int data = 50 / 0; //这里抛出异常之后直接跳转到catch，若异常被catch住并处理，catch后面的代码正常运行
            System.out.println("这里不能被执行。。。");
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        System.out.println("这里不能被执行。。。");
    }


    /**
     * catch中又抛出异常，相当于try-catch这个整体最终还是抛出一个异常，导致程序提前中断，catch后面的代码不能被执行
     */
    @Test
    public void test2_6() {
        try {
            int data = 50 / 0; //这里抛出异常之后直接跳转到catch
            System.out.println("这里不能被执行。。。");
        } catch (ArithmeticException e) {
            int data = 50 / 0; //catch中又抛出异常，相当于try-catch这个整体最终还是抛出一个异常，导致程序提前中断，catch后面的代码不能被执行
        }
        System.out.println("这里不能被执行。。。");
    }


    /**
     * 程序并没有抛出异常所以代码可简化为：
     * int data = 50 / 1;
     * System.out.println("这里可以被执行。。。");
     * System.out.println("这里能被执行。。。");
     */
    @Test
    public void test2_7() {
        try {
            int data = 50 / 1;
            System.out.println("这里可以被执行。。。");
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("这里能被执行。。。");
    }


    /**
     * 异常对象抛出后会依次匹配每个catch，直到被捕获到；若没有被捕获到，相当于产生异常没有catch,导致程序提前中断
     * 注意： 1 catch 异常类范围要从小到大向下排列，若顺序颠倒，会编译不通过
     * 2 异常对象至多只能被一个catch捕获处理
     * 3 异常 对象一旦被其中一个捕获，便不会继续匹配下面的catch
     * 4 若没有被捕获到，相当于产生异常没有被catch
     */
    @Test
    public void test2_8() {
        try {
            int a[] = new int[5];
            a[5] = 30 / 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs");
        } catch (Exception e) {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("这里能被执行");
    }


    /**
     * In this example, try block contains two exceptions. But at a time only one com.demo.exception occurs and its corresponding catch block is invoked.
     */
    @Test
    public void test2_9() {
        try {
            int a[] = new int[5];
            a[5] = 30 / 0;  //这里产生异常直接跳到catch
            System.out.println(a[10]); //这里没机会执行，所以不会产生运行时异常
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs");
        } catch (Exception e) {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("这里能被执行");
    }


    /**
     * In this example, we generate NullPointerException, but didn't provide the corresponding com.demo.exception type.
     * In such case, the catch block containing the parent com.demo.exception class Exception will invoked.
     */
    @Test
    public void test2_10() {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        } catch (Exception e) {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("这里能被执行");
    }



}
