package com.demo.exception;

import org.testng.annotations.Test;

/**
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html
 *
 * 在程序中出现的错误称为异常；Java采用类class模拟异常；所有异常类的父类:java.lang.Throwable
 * Java把程序中出现的异常信息封装到异常类对应的异常对象当中,然后把它交给运行时系统
 * Creating an exception object and handing it to the runtime system is called throwing an exception.
 * <p>
 * Java提供了两种错误异常类: Error类和Exception类,两者都继承Throwable类
 * Error类发生在程序运行期间，这类错误不可恢复(处理)的，一旦发生就会终止程序执行
 * Exception类表示可恢复异常，分为两类：检查/编译时异常（check exception）和运行异常（runtime exception）
 * 检查/编译时异常（check exception）就是在程序编译时就会抛出的异常(编译器抛出)
 * 运行异常（runtime exception）是在程序运行阶段由JVM抛出的异常
 * 编译时异常类全部直接继承Execption,也就是Execption的直接子类都是编译时异常
 * 运行时异常都是直接继承RunTimeExecptiom
 * <p>
 * 异常发生后如果不进行处理就会导致程序崩溃，因此我们需要进行异常处理(exception handling).
 * 异常处理两种方式：throws声明抛出 或者 捕获try-catch
 * 检查/编译时异常（check exception）在程序编写过程中就要进行异常处理； 运行异常（runtime exception）在程序编写过程中可以不进行异常处理
 * <p>
 * 编译时异常相对运行时异常发生几率更大，所以抛出的时间更早(编译阶段)，所以在程序运行之前就要进行异常处理；
 * 但是所有的异常都在运行之前就要处理，负担将会非常大，所以把这些异常定义为运行时异常
 */
public class ExecptionDemo {

    /**
     * 程序抛出异常而没有被处理会导致程序提前结束，从而使得后面的代码不能被执行
     */
    @Test
    public void test() {

        //程序执行到这里时候发生异常时间，JVM会自动创建ArithmeticException类型的对象，这个对象包含了详细的异常信息，然后JVM根据异常对象在call stack寻找execption handler
        // JVmM没有找到合适的的execption handler(异常事件没有被处理)， 程序执会在异常对象产生的位置中断， the runtime system (the program) terminates
        // 信息输出到控制台上
        //然后由于异常事件没有被处理，
        //ArithmeticException e=0x1234
        int data = divide(1, 0);
        System.out.println("Rest of the code cannot be executed");//系统自动抛出一个内置异常对象给运行时系统，默认处理方式是打印该对象的信息，并中断程序运行
    }


    /**
     * 添加异常处理
     * adding some exception handling
     */
    @Test
    public void test2() {

        try {
            int divideResult = divide(1, 0);//
        } catch (ArithmeticException e) {
            System.out.println("除数不能等于0");
        }

        System.out.println("Rest of the code can be executed due to execption handling");//系统自动抛出一个内置异常对象给运行时系统，默认处理方式是打印该对象的信息，并中断程序运行
        int multiplyResult=multiply(3,7);
        System.out.println("multiplyResult is "+multiplyResult);
    }


    public static int divide(int m, int n) {
        return m / n;
    }
    public int multiply(int m, int n) {
        return m * n;
    }

}
