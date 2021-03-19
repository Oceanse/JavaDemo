package com.demo.concurrent.ThreadImpl.demo3_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口和实现Runnable接口实现创建多线程的区别就在于，能不能返回值，需不需要返回值。需要返回值的，最好使用Callable接口。
 * 这个案例中实际上并不需要返回值，所以实际上使用Runnalble接口更好
 */
public class CallableDemo2 {
    static int ticket=100;


    //test()方法的当前对象是是main方法中的new CallableDemo2()，所以test()方法中所有的ticket变量都是同一个对象的ticket变量
    public void test(){
        Callable c1= new Callable<String>(){
            @Override
            public String call() {
                while(ticket>0){
                    System.out.println(Thread.currentThread().getName()+" "+ticket);
                    ticket--;
                }
                return null;
            }
        };

        Callable c2= new Callable<String>(){
            @Override
            public String call() {
                while(ticket>0){
                    System.out.println(Thread.currentThread().getName()+" "+ticket);
                    ticket--;
                }
                return null;
            }
        };

        Callable c3= new Callable<String>(){
            @Override
            public String call() {
                while(ticket>0){
                    System.out.println(Thread.currentThread().getName()+" "+ticket);
                    ticket--;
                }
                return null;
            }
        };


        FutureTask<String> futureTask=new FutureTask<>(c1);
        FutureTask<String> futureTask2=new FutureTask<>(c2);
        FutureTask<String> futureTask3=new FutureTask<>(c3);
        new Thread(futureTask).start();
        new Thread(futureTask2).start();
        new Thread(futureTask3).start();
    }

    public static void main(String[] args) {
       new CallableDemo2().test();
    }
}

