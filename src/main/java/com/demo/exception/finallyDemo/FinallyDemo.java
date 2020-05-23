package com.demo.exception.finallyDemo;


import org.testng.annotations.Test;

/**
 * finally
 * finally block is a block that is used to execute important code such as closing connection, stream etc(释放资源).
 * Java finally block is always executed whether com.demo.exception is handled or not.
 * Java finally block follows try or catch block.
 * <p>
 *
 *  注意：
 * 如果在执行finally退出了jvm( System.exit(0)),那么后面的finally不会被执行;
 *
 */
public class FinallyDemo {


    /**
     * try-finally没有异常
     * finally example where com.demo.exception doesn't occur.
     */
    @Test
    public void test() {
        try {
            int data = 25 / 5;
            System.out.println(data);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }


    /**
     * try-catch-finally没有异常
     * finally example where com.demo.exception doesn't occur.
     */
    @Test
    public void test1_2() {
        try {
            int data = 25 / 5;
            System.out.println(data);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }




    /**
     * try-finally发生异常,没被处理
     * Let's see the java finally example where com.demo.exception occurs and not handled.
     * 如果异常没有被处理,finally block 可以被执行，但是被执行后程序就此中断，finally block后面的代码不会执行
     */
    @Test
    public void test2_1() {
        try {
            int data = 25 / 0;//发生异常后直接跳转到finally
            System.out.println(data);
        } finally {
            System.out.println("finally block is always executed");//从发生异常的地方跳转到这里，由于异常没被处理，所以程序执行到这里中断
        }
        System.out.println("这里代码不会被执行");//如果异常没有被处理,finally block 可以被执行，但是被执行后程序就此中断，finally block后面的代码不会执行
    }


    /**
     * try-catch-finally发生异常，没被处理
     * Let's see the java finally example where com.demo.exception occurs and not handled.
     * 如果异常没有被处理,finally block 可以被执行，但是被执行后程序就此中断，finally block后面的代码不会执行
     */
    @Test
    public void test2_2() {
        try {
            int data = 25 / 0;//发生异常后匹配catch
            System.out.println(data);//跳过
        } catch (NullPointerException e) {//没有catch住
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");//由于异常没被处理，所以程序执行到这里中断
        }
        System.out.println("这里代码不会被执行");//如果异常没有被处理,finally block 可以被执行，但是被执行后程序就此中断，finally block后面的代码不会执行
    }


    /**
     * try-catch-finally发生异常但被处理
     * Let's see the java finally example where com.demo.exception occurs and handled.
     * 抛出异常，被catch处理掉，finally block及之后的代码都可以被执行
     */
    @Test
    public void test3() {
        try {
            int data = 25 / 0;//发生异常后匹配catch
            System.out.println(data);//跳过
        } catch (ArithmeticException e) {//被catch住，因此异常得到处理
            System.out.println("e: " + e);
        } finally {
            System.out.println("finally block is always executed");//异常被catch逻辑处理完，然后执行finally代码
        }
        System.out.println("这里可以被执行");//异常被catch住处理，这里可以被执行
    }


    /**
     * 通过debug发现语句执行顺序：
     * System.out.println("*******************")------>System.out.println("finally block is always executed")-------->return;
     */
    @Test
    public void test4() {
        try {
            System.out.println("*******************");
            return;
        } finally {
            System.out.println("finally block is always executed");
        }
    }



    @Test
    public static void test5() {
        int num=cal();
        System.out.println("num="+num);
    }

    public static int cal(){
        int i=10;
        try{
            return i;
            /*
            * 理解成 int tmp=i;
            * return temp;
            * */
        }finally {
            i++;
            System.out.println("i="+i);

        }
    }



    @Test
    public void test6() {
        try {
            //退出JVM
            System.exit(0);
        } finally {
            System.out.println("这里不会被执行");
        }
    }


}
