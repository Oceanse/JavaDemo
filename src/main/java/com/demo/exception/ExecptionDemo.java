package com.demo.exception;

import org.testng.annotations.Test;

/**
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html
 *
 * 1 为什么需要异常处理机制？
 *   在理想境界中，程序永远不会出现问题，用户输入的数据永远是正确的，逻辑没有任何问题 ，选择打开的文件也一定是存在的，
 *   内存永远是够用的，硬件是永远没有问题的……反正没有任何问题！但是一旦出现这些问题，如果处理不好，程序就不能正常运行了，用户就有可能再也不使用这个程序了。
 *   statement 1;
 *   statement 2;
 *   statement 3;  (异常或者错误导致程序中断)Exception occurs and disrupts the normal flow of the application
 *   statement 4;
 *   statement 5;
 *   statement 6;
 *   If we perform com.demo.exception handling, the rest of the statement will be executed.
 *  通过异常处理机制可以使得程序在发生异常后依然能够运行下去，使得我们的程序具备更好的容错性，更加健壮
 *  对于构建大型、健壮、可维护的系统而言，错误处理是整个应用需要考虑的重要事情，所以在开发过程中不能只是专注于"做对的事情"，需要进行全面的考虑
 *
 *
 *
 *
 *
 * 2 异常定义：
 *  在程序中出现的错误称为异常；
 *  Java采用类class模拟异常；它会把程序中出现的异常信息封装到异常类对应的异常对象当中,所有异常类的父类:java.lang.Throwable；
 *  然后把它交给运行时系统
 *  Creating an exception object and handing it to the runtime system is called throwing an exception.
 *
 *
 *
 * 3异常分类
 *  Java提供了两种错误异常类: Error类和Exception类,两者都继承Throwable类
 *   Error类发生在程序运行期间，这类错误不可恢复(处理)的，一旦发生就会终止程序执行(内存溢出，线程死锁)
 *   Exception类表示可恢复异常，分为两类：检查/编译时异常（check exception）和运行异常（runtime exception）
 *
 *     检查/编译时异常（check exception）就是在程序编译时就会抛出的异常(编译器抛出); 编译时异常类全部直接继承Execption,也就是Execption的直接子类都是编译时异常
 *       包括：IOException，ClassNotFoundException
 *     运行异常（runtime exception）是在程序运行阶段由JVM抛出的异常;运行时异常都是直接继承RunTimeExecptiom
 *       包括：ClassCastException, ArrayIndexOutOfBoundsException, NullPointerException, ArithmeticException
 *
 *
 * 4异常处理
 *  当业务逻辑代码出现问题时候，系统会自动生成一个包含错误信息的异常类对象，然后把这个对象提交给java运行时环境(JRE)，JRE会首先在当前方法中进行处理或者抛给上层方法，
 *  上层方法采取同样的处理方式，如果最后异常对象没有被处理，最后只能有JRE处理，它的默认处理方式就是打印异常栈信息，并且中断程序运行
 *  异常发生后如果不进行处理就会导致程序崩溃，因此我们需要进行异常处理(exception handling).
 *  异常处理方式：程序自动抛出异常类对象， throw new Execptopn()手动抛出异常类对象,  throws方法声明抛出异常类， try-catch捕获处理异常类对象
 *
 *  检查/编译时异常（check exception）在程序编写过程中就要进行异常处理； 运行异常（runtime exception）在程序编写过程中可以不进行异常处理
 *
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
        // JVmM没有找到合适的的execption handler(异常事件没有被处理)， 程序执会在异常对象产生的位置中断，the runtime system (the program) terminates，打印异常信息到控制台上
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

        System.out.println("Rest of the code can be executed due to execption handling");
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
