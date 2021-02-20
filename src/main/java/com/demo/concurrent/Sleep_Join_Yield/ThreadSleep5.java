package com.demo.concurrent.Sleep_Join_Yield;

//线程安全问题
public class ThreadSleep5 implements Runnable {


    int ticket = 100;

    @Override
    public void run() {

        while(ticket>0){
            try {
               /* 三个线程对象拥有着同一个Window6对象，也就是共同执行同一个线程体
                 三个线程对象执行到这里时都会休眠1000ms，进入阻塞状态（暂停执行）,
                 把cpu片段让出给其他两个线程，睡眠到期进入就绪状态
                 效果类似于三个线程几乎同时执行线程体，然后几乎同时阻塞1s，然后1s后几乎同时苏醒，结果表现为每隔1s钟，打印三次，出现重票、错票
                 */
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"票号"+ticket);
            ticket--;
        }
    }

    public static void main(String[] args) {

        //创建三个线程
        ThreadSleep5 window=new ThreadSleep5();
        Thread thread=new Thread(window);
        Thread thread2=new Thread(window);
        Thread thread3=new Thread(window);

        //启动三个线程
        thread.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");


        thread.start();
        thread2.start();
        thread3.start();
    }
}
