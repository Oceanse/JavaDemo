package com.demo.concurrent.Sleep_Join_Yield;

public class ThreadSleep3 extends Thread {

    @Override
    public void run() {

        try {
            Thread.sleep(60000);//Thread中的run方法没有抛异常，所以这里不能throws异常
        } catch (InterruptedException e) {
            System.out.println("sleep is interrupted");
            e.printStackTrace();
        }
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {


        ThreadSleep3 threadDemo=new ThreadSleep3();
        threadDemo.setName("子线程");
        threadDemo.start();//子线程执行线程体时因为sleep会阻塞60s，60s之后才会重新进入就绪状态

        /*Thread.sleep()是Thread类的一个静态方法，使当前线程(主线程)休眠，进入阻塞状态,主线程执行到这里会阻塞1s
        也就是前1s,主线程和子线程都处于阻塞状态 */
        Thread.sleep(1000);


       /*1s后，子线程仍处于阻塞状态，主线程进入就绪状态，通过threadDemo.interrupt()中断子线程的睡眠状态
       * 如果没有threadDemo.interrupt()子线程会一致阻塞60s
       * */
        threadDemo.interrupt();//中断线程的睡眠状态，会触发sleep抛出InterruptedException异常,所以sleep一定要捕获异常，这样线程才会执行下去



    }
}
