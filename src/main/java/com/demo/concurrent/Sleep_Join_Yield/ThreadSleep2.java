package com.demo.concurrent.Sleep_Join_Yield;

public class ThreadSleep2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //main方法整个方法体都是主线程的线程体


        Thread.currentThread().setName("主线程");
        //主线程执行到这里时会休眠5s，此时只有一个主线程，所以5s后，主线程才会继续执行主线程体后面的代码
        // 此时只有一个单线程，即主线程

        long start=System.currentTimeMillis();
        Thread.sleep(5000);
        long end=System.currentTimeMillis();
        System.out.println("时间过去了"+(end-start)/1000+"s");




        //5s之后开启新的线程，并和主线程剩余的代码并发执行
        ThreadSleep2 threadDemo=new ThreadSleep2();
        threadDemo.setName("子线程");
        threadDemo.start();


        //主线程代码
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
