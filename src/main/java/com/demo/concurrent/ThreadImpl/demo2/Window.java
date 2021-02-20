package com.demo.concurrent.ThreadImpl.demo2;

public class Window extends Thread {

    //保证三个线程共享一个变量
    static int ticket = 100;

    @Override
    public void run() {

        while(ticket>0){
            System.out.println(Thread.currentThread().getName()+"票号"+ticket);
            ticket--;
        }
    }

    public static void main(String[] args) {

        //创建三个线程
        Window window=new Window();
        Window window2=new Window();
        Window window3=new Window();

        window.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        //启动三个线程，三个线程并发执行，没有明确的先后顺序
        window.start();
        window2.start();
        window3.start();
    }
}
