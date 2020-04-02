package com.demo.thread;

public class ThreadRun implements Runnable{
    int ticket=100;
    @Override
    public void run() {
        while (ticket>0){
            System.out.println("票号："+ticket);
            ticket--;
        }
    }

    public static void main(String[] args) {

        /*方式1
        ThreadRun t=new ThreadRun();
        Thread t2=new Thread(t);
        t2.start();*/

        /*方式2
        new Thread(new ThreadRun()).start();*/

        //方式3
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

    }
}
