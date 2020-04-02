package com.demo.exception;

import org.testng.annotations.Test;

import java.io.IOException;


/**
 * throws出现在方法函数头；而throw出现在函数体。
 * throws是方法可能抛出异常的声明，用在声明方法时，表示该方法可能要抛出异常；throw则是抛出了异常，执行throw则一定抛出了某种异常。
 * 两者都是消极处理异常的方式（这里的消极并不是说这种方式不好），只是抛出或者可能抛出异常，但是不会由函数去处理异常，真正的处理异常由函数的上层调用处理。
 *
 */
public class ThrowsDemo {

    void a() throws NullPointerException {
        System.out.println("hello");
        throw new NullPointerException("npe异常");//unchecked com.demo.exception
    }


    //由于a()抛出的是运行时异常，b()可以不处理
    void b(){
        a();
    }











    /**
     * Let's see the example of java throws clause which describes that checked exceptions can be propagated by throws keyword.
     *
     * @throws IOException
     */
    void m() throws IOException {
        System.out.println("hello");
        throw new IOException("device error");//checked com.demo.exception
    }

    void n() throws IOException {
        m();
    }


    /**
     * Rule: If you are calling a method that declares an com.demo.exception, you must either caught or declare the com.demo.exception.
     * case1: You handle the com.demo.exception
     */
    @Test
    public void test() {
        try {
            n();
        } catch (IOException e) {
            System.out.println("com.demo.exception handled");
        }
        System.out.println("normal flow...");
    }




    /**
     * Rule: If you are calling a method that declares an com.demo.exception, you must either caught or declare the com.demo.exception.
     * Case2: You declare the com.demo.exception
     * A)In case you declare the com.demo.exception, if com.demo.exception does not occur, the code will be executed fine.
     */

    void k() throws IOException{
        System.out.println(123);
    }

    @Test
    public void test2() throws IOException {
        k();
        System.out.println("normal flow...");
    }








    /**
     * Rule: If you are calling a method that declares an com.demo.exception, you must either caught or declare the com.demo.exception.
     * Case2: You declare the com.demo.exception
     * B)In case you declare the com.demo.exception if com.demo.exception occures, an com.demo.exception will be thrown at runtime because throws does not handle the com.demo.exception.
     */

    void p() throws IOException{
        throw new IOException();
    }

    @Test
    public void test4() throws IOException {
        p();//p()发生异常只是被抛出去，并没有进行处理，所以程序执行到这里直接throws异常，然后程序结束，后面不会被执行
        System.out.println("normal flow...");
    }


}
