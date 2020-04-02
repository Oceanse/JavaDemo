package com.demo.concurrent.ThreadImpl;

public class Window4 implements Runnable {


    int ticket = 100;

    @Override
    public void run() {

        while(ticket>0){
            System.out.println(Thread.currentThread().getName()+"票号"+ticket);
            ticket--;
        }
    }

    public static void main(String[] args) {

        //创建三个线程
        Runnable r=new Window4();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();

    }
}
