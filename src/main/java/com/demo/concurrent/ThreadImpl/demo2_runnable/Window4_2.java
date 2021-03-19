package com.demo.concurrent.ThreadImpl.demo2_runnable;

/*
()->{},其中{}可以封装成一个方法
*/
public class Window4_2 {
    int ticket = 100;

    public void test() {
        new Thread(() ->
                sellTickets()).start();
        new Thread(() ->
                sellTickets()).start();

        new Thread(() ->
                sellTickets()).start();
    }

    public void sellTickets() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "票号" + ticket);
            ticket--;
        }
    }

    public static void main(String[] args) {
        new Window4_2().test();
    }

}
