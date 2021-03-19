package com.demo.concurrent.ThreadImpl.demo2_runnable;

public class Window2 implements Runnable {

    //三个线程共享一个对象的变量
    int ticket = 100;

    @Override
    public void run() {
        while(ticket>0){
            System.out.println(Thread.currentThread().getName()+"票号"+ticket);//这一句和下面ticket--执行时候存在时间差，所以可能会出现重票
            ticket--;
        }
    }

    public static void main(String[] args) {


        //创建三个线程，多个线程对象共用一个Runnable接口实现类
        Runnable window=new Window2();
        Thread thread=new Thread(window);
        Thread thread2=new Thread(window);
        Thread thread3=new Thread(window);

        //启动三个线程，三个线程并发执行，没有明确的先后顺序
        thread.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");


        thread.start();
        thread2.start();
        thread3.start();
    }
}
