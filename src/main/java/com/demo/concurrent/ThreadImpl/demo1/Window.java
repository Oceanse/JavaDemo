package com.demo.concurrent.ThreadImpl.demo1;

public class Window extends Thread {

    //继承Thread方式要把共享成员变量设置为静态变量，保证三个线程共享一个变量
    static int ticket = 10;

    @Override
    public void run() {

        while(ticket>0){
           /* //sleep会增大重票和负数票号的概率
           try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
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
