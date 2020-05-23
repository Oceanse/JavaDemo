package com.demo.exception;

import org.testng.annotations.Test;

import java.io.IOException;


/**
 * throws出现在方法函数头,用来声明方法可能抛出异常, 抛给系统或者方法调用者
 *
 * throws vs throw:
 * throws出现在方法函数头而throw出现在函数体。
 * throws是方法可能抛出异常的声明；throw则是抛出了异常，执行throw则一定抛出了某种异常。
 * 两者都是消极处理异常的方式（这里的消极并不是说这种方式不好），只是抛出或者可能抛出异常，但是不会由函数去处理异常，真正的处理异常由函数的上层调用处理。
 *
 */
public class ThrowsDemo {



    void a() throws NullPointerException {
        System.out.println("hello");
        throw new NullPointerException("npe异常");//unchecked com.demo.exception
    }


    /**
     * 由于a()抛出的是运行时异常，可以不处理
     */
    @Test
    public void test() {
        a();
    }



    void b() throws IOException {
        System.out.println("hello");
        throw new IOException("device error");//checked com.demo.exception
    }

    /**
     * Rule: If you are calling a method that declares an com.demo.exception, you must either caught or declare the exception.
     * 由于b()抛出的是编译时异常，必须处理，可以throws处理，传递给该方法的调用者处理
     */
    @Test
    public void test2() throws IOException{
        b();
    }


    /**
     * Rule: If you are calling a method that declares an com.demo.exception, you must either caught or declare the com.demo.exception.
     * 由于b()抛出的是编译时异常，必须处理，可以 try-catch处理
     */
    @Test
    public void test3() {
        try {
            b();
        } catch (IOException e) {
            System.out.println("com.demo.exception handled");
        }
        System.out.println("normal flow...");
    }



    void c() throws IOException{
        System.out.println(123);
    }

    /**
     * Rule: If you are calling a method that declares an com.demo.exception, you must either caught or declare the com.demo.exception.
     * In case you declare the com.demo.exception, if exception does not occur, the code will be executed fine.
     * c()虽然不会抛出IOException， 这里依然必须throws或者try-cach处理异常
     */
    @Test
    public void test4() throws IOException {
        c();
        System.out.println("normal flow...");
    }


    /**
     * Rule: If you are calling a method that declares an com.demo.exception, you must either caught or declare the com.demo.exception.
     * Case2: You declare the com.demo.exception
     * B)In case you declare the com.demo.exception if com.demo.exception occures, an com.demo.exception will be thrown at runtime because throws does not handle the com.demo.exception.
     */

    void d() throws IOException{
        throw new IOException();
    }

    @Test
    public void test4s() throws IOException {
        d();//d()发生异常只是被抛出去，并没有进行处理，所以程序执行到这里直接throws异常，然后程序结束，后面不会被执行
        System.out.println("normal flow...");
    }


}
