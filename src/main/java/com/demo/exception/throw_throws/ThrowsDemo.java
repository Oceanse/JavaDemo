package com.demo.exception.throw_throws;

import org.testng.annotations.Test;

import java.io.IOException;


/**
 * throws出现在方法函数头,用来声明方法可能抛出异常(只是可能),当不知道异常如何处理的时候可以抛给系统或者上层方法(方法调用者)
 * 若抛出的是编译时异常，上层方法可以选择继续往上抛或者处理掉，若在最上层的方法还有进行处理，那么最终会交给jvm处理：打印异常信息并中断程序
 * 若抛出的是运行时异常，上层方法可以不处理
 *
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
     * 由于a()抛出的是运行时异常，可以不处理,交给jvm处理
     */
    @Test
    public void test() {
        System.out.println("befor...");
        a();//jvm处理此异常
        System.out.println("after...");
    }



    void b() throws IOException {
        if(true) {
            System.out.println("hello");
            throw new IOException("device error");//checked com.demo.exception
        }
        System.out.println("hi========");//上面被执行的话，这里永远不会被执行
    }

    /**
     * 由于b()抛出的是编译时异常，可以throws传递给该方法的调用者处理或者catch处理，
     */
    @Test
    public void test2() throws IOException{
        System.out.println("befor...");
        b();//这里出现异常，然后将异常throws给jvm,因此程序到此结束
        System.out.println("after...");//这里不会被执行
    }


    /**
     * 由于b()抛出的是编译时异常，可以throws传递给该方法的调用者处理或者catch处理，
     */
    @Test
    public void test3() {
        try {
            System.out.println("befor...");
            b();//这里发生异常直接跳到catch
            System.out.println("after...");//这里不会被执行
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("normal flow...");
    }



    //throws出现在方法函数头,用来声明方法可能抛出异常(只是可能)
    void c() throws IOException{
        System.out.println(123);
    }

    /**
     * c()虽然不会抛出IOException， 这里依然必须throws或者try-cach处理异常
     */
    @Test
    public void test4() throws IOException {
        System.out.println("befor...");
        c();
        System.out.println("after...");
    }



}
