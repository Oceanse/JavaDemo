package com.demo.concurrent.Sleep_Join_Yield;

public class ThreadJoin2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {


        ThreadJoin2 threadDemo=new ThreadJoin2();

        threadDemo.setName("子线程");
        threadDemo.start();//在主线程中启动子线程

        //主线程执行到这行代码时，子线程join进来，主线程进入阻塞状态，直到子线程执行完毕，才会执行下面主线程的代码
        //从这里整个程序变成了单线程
        threadDemo.join();




        Thread.currentThread().setName("主线程");

        //主线程
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
