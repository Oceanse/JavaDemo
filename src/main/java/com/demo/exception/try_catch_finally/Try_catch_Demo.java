package com.demo.exception.try_catch_finally;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 *当业务逻辑代码出现问题时候，系统会自动生成一个包含错误信息的异常类对象，然后把这个对象提交给java运行时环境(JRE)，JRE会首先在当前方法中进行处理或者抛给上层方法，
 *上层方法采取同样的处理方式，如果最后异常对象没有被处理，最后只能有JRE处理，它的默认处理方式就是打印异常栈信息，并且中断程序运行
 *
 * 异常处理方式之try-catch:The catch block contains code that is executed if and when the exception handler is invoked.
 * The runtime system invokes the exception handler when the handler is the first one in the call stack whose ExceptionType matches the type of the exception thrown.
 * try {
 *    // Protected code
 * } catch (ExceptionType1 e1) {
 *    // Catch block
 * } catch (ExceptionType2 e2) {
 *    // Catch block
 * } catch (ExceptionType3 e3) {
 *    // Catch block
 * }
 *
 * 注意：
 * 1 try中某条语句发生异常，会直接跳转到相应的catch(exception handler), try中剩余的语句会直接被跳过
 * 2 catch可以多个，但是范围只能从小到大，否则编译不通过
 * 3 catch可以有多个，但是每次只能有一个被执行
 * 4 catch只能捕获try抛出的异常，不能捕获catch抛出的异常
 * 5 若 catch没能捕获异常，程序会在抛出异常的地方中断
 *
 */
public class Try_catch_Demo {


    @Test
    public void test() {

        //当业务逻辑代码出现问题时候，系统会自动生成一个包含错误信息的异常类对象，然后把这个对象提交给java运行时环境(JRE)，JRE默认处理方式就是打印异常栈信息，并且中断程序运行
        //throw com.demo.exception
        int data = 50 / 0;

        // The rest of the code is not executed; There can be 100 lines of code after exception. So all the code after exception will not be executed.
        System.out.println("Rest of the code cannot be executed");//系统自动抛出一个内置异常对象给运行时系统，默认处理方式是打印该对象的信息，并中断程序运行
    }


    /**
     * 程序抛出的异常没有被catch住，相当于没有catch导致程序提前结束, 从而使得catch后面的代码不能被执行
     */
    @Test
    public void test1_2() {
        int[] array = new int[5];
        try {
            int re = array[0] / 0;  //系统自动抛出一个内置异常对象给运行时系统，运行时系统会寻找相应的异常handler,如果没有相应的handler,jvm默认处理方式是打印该对象的信息并中断程序
        } catch (NullPointerException e) {//上面的异常对象不属于catch声明的异常类，该对象不能被捕获，还是以默认方式（打印该对象的信息,并中断程序)处理，相当于没有catch,所以catch后面的代码不能被执行
            e.printStackTrace();
        }

        System.out.println("异常没被捕获，所以这里不能被执行。。。");
    }


    /**
     * 抛出的异常被catch住并处理，catch后面的代码正常运行
     */
    @Test
    public void test2_1() {
        int[] array = new int[5];
        try {
            int re = array[0] / 0;  //系统自动抛出一个内置异常
            //系统自动抛出内置异常对象属于catch声明的异常类而被捕获(catch),然后系统便不再会以默认方式(打印该对象的信息并中断程序)来处理，而是按照catch代码块中的逻辑来处理
        } catch (ArithmeticException e) {
            e.printStackTrace();//e.printStackTrace(); 使用这个方法打印出来的是所有出错的信息，包括了使用getMessage()方法打印出来的信息
        }

        System.out.println("catch后面可以被执行。。。");//程序会正常继续执行
    }


    /**
     * 使用异常类对象的父类也能够捕获到该异常
     * 抛出的异常被catch住并处理，catch后面的代码正常运行
     */
    @Test
    public void test2_2() {
        int[] array = new int[5];
        try {
            int re = array[0] / 0;
        } catch (RuntimeException e) {//使用异常类对象的父类也能够捕获到该异常，因为异常对象也是异常类父类的对象
            System.out.println("Can't divided by zero");// displaying the custom message
            e.printStackTrace();
        }

        System.out.println("catch后面可以被执行。。。");
    }




    /**
     * try中的code block 执行到int data = 50 / 0时候抛出异常，直接跳转到catch，若异常被catch住并处理，catch后面的代码正常运行
     * try中的code block剩余的代码肯定不能再被执行
     * 整体上呈现一种跳跃执行的感觉
     */
    @Test
    public void test2_4() {
        try {
            int data = 50 / 0; //这里抛出异常之后直接跳转到catch，若异常被catch住并处理，catch后面的代码正常运行
            System.out.println("这里不能被执行。。。");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("catch后面可以被执行。。。");
    }


        /**
         * try中的code block 执行到int data = 50 / 0时候抛出异常，直接跳转到catch
         * 程序抛出的异常对象没有被catch住，相当于没有catch导致程序提前结束
         */
        @Test
        public void test2_5 () {
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
        public void test2_6 () {
            try {
                int data = 50 / 0; //这里抛出异常之后直接跳转到catch
                System.out.println("这里不能被执行。。。");
            } catch (ArithmeticException e) {
                throw new ArrayIndexOutOfBoundsException(); //catch处理逻辑中又抛出异常，相当于try-catch这个整体最终还是抛出一个异常，导致程序提前中断，catch后面的代码不能被执行
            }
            System.out.println("这里不能被执行。。。");
        }

        /**
         * catch中又抛出异常，相当于try-catch这个整体最终还是抛出一个异常
         * 另外catch不能捕获catch代码块中抛出的异常，所以后面的catch不能捕获前面catch抛出的异常
         * 程序提前中断，catch后面的代码不能被执行
         */
        @Test
        public void test2_6_2 () {
            try {
                int data = 50 / 0; //这里抛出异常之后直接跳转到catch
                System.out.println("这里不能被执行。。。");
            } catch (ArithmeticException e) {
                int data = 50 / 0; //catch中又抛出异常
            } catch (RuntimeException e) {//catch不能捕获catch代码块中抛出的异常
                System.out.println("这里不能捕获上面catch捕获的异常");
            }
            System.out.println("这里不能被执行。。。");
        }


        /**
         * 程序并没有抛出异常所以下面代码等价于：
         * int data = 50 / 1;
         * System.out.println("这里可以被执行。。。");
         * System.out.println("这里能被执行。。。");
         */
        @Test
        public void test2_7 () {
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
         * 注意：
         * 1 catch 异常类范围要从小到大向下排列，若顺序颠倒，会编译不通过
         * 2 异常对象至多只能被一个catch捕获处理
         * 3 异常 对象一旦被其中一个捕获，便不会继续匹配下面的catch
         * 4 若没有被捕获到，相当于产生异常没有被catch
         */
        @Test
        public void test2_8 () {
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
     * 异常对象被父类捕获
     * In this example, we generate NullPointerException, but didn't provide the corresponding com.demo.exception type.
     * In such case, the catch block containing the parent com.demo.exception class Exception will invoked.
     */
    @Test
    public void test2_9 () {
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


        /**
         *  try中a[5] = 30 / 0; 抛出异常，剩余的代码肯定不能再被执行
         *  整体上呈现一种跳跃执行的感觉
         * In this example, try block contains two exceptions. But at a time only one exception occurs
         * and its corresponding catch block is invoked.
         */
        @Test
        public void test2_10 () {
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
     *  try中new FileInputStream("none.txt") 抛出异常，剩余的代码肯定不能再被执行
     *  整体上呈现一种跳跃执行的感觉
     * In this example, try block contains two exceptions. But at a time only one exception occurs
     * and its corresponding catch block is invoked.
     */
    @Test
    public void test2_10_2() {
        try {
            //FileInputStream(String name) throws FileNotFoundException
            FileInputStream fileInputStream = new FileInputStream("none.txt");//这里抛出异常后直接跳转到第一个catch, 即使后面语句抛出的异常可以被catch,也不会被执行

            //read() throws IOException
            fileInputStream.read();
            System.out.println("No execution");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOException occurs");
        }}


    /**
     * In Java SE 7 and later, a single catch block can handle more than one type of exception. This feature can reduce code duplication
     * Note: If a catch block handles more than one exception type, then the catch parameter is implicitly final.
     */
    @Test
    public void test2_10_3(){
        try {
           int[] score={100,120};
            for (int i = 0; i < score.length; i++) {
                System.out.println(score[i] / i);
            }
        } catch (ArithmeticException | IndexOutOfBoundsException e) {//异常变量都有隐式的final修饰，因此不能对异常变量重新赋值
            //e=new ArithmeticException(); the catch parameter e is final and therefore you cannot assign any values to it within the catch block.
            throw e;
        }}



}