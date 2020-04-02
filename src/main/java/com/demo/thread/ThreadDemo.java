package com.demo.thread;

public class ThreadDemo extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //线程1
        ThreadDemo t1=new ThreadDemo();
        t1.start();

        //线程2
        ThreadDemo t2=new ThreadDemo();
        t2.start();

       /*主线程
       for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }*/

    }
}
