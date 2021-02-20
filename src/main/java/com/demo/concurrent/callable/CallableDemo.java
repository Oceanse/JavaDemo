package com.demo.concurrent.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口和实现Runnable接口实现创建多线程的区别就在于，能不能返回值，需不需要返回值。需要返回值的，最好使用Callable接口。
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyThread mt=new MyThread();
        MyThread2 mt2=new MyThread2();
        MyThread3 mt3=new MyThread3();

        FutureTask<String> futureTask=new FutureTask<>(mt);
        FutureTask<String> futureTask2=new FutureTask<>(mt2);
        FutureTask<String> futureTask3=new FutureTask<>(mt3);
        new Thread(futureTask).start();
        new Thread(futureTask2).start();
        new Thread(futureTask3).start();

        Thread.sleep(1000);
        String res = futureTask.get();
        String res2 = futureTask2.get();
        String res3 = futureTask3.get();
        System.out.println("res="+res);
        System.out.println("res2="+res2);
        System.out.println("res3="+res3);

    }
}


class MyThread implements Callable<String>{
    @Override
    public String call() {
        int sum=0;
        for (int i = 0; i <101; i++) {
            sum+=i;
            System.out.println("aa");
        }
        return Thread.currentThread().getName()+"aa: "+sum;
    }
}

class MyThread2 implements Callable<String>{
    @Override
    public String call() {
        int sum=0;
        for (int i = 0; i <101; i++) {
            sum+=i;
            System.out.println("bb");
        }
        return Thread.currentThread().getName()+"bb: "+sum;
    }
}

class MyThread3 implements Callable<String>{
    @Override
    public String call() {
        int sum=0;
        for (int i = 0; i <101; i++) {
            sum+=i;
            System.out.println("cc");
        }
        return Thread.currentThread().getName()+"cc: "+sum;
    }
}