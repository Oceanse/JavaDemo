package com.demo.concurrent.ThreadImpl;

public class Window3 {

    //三个线程共享一个对象的变量
     int ticket = 100;



   /*
   创建接口实现类对象

   new 接口名（）{
        重写接口方法
        }
    */
    public static void main(String[] args) {
        new Window3().test();

    }

    public void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"票号"+ticket);
                    ticket--;
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"票号"+ticket);
                    ticket--;
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"票号"+ticket);
                    ticket--;
                }
            }
        }).start();
    }
}
