package com.demo.concurrent.thread_safe;


/*
同步编程模型：t1线程和t2线程执行，只有t1线程执行结束后t2才能执行
异步编程模型：t1线程执行t1的，t2线程执行t2的，谁也不等谁

 线程同步的使用条件：多个线程共同修改同一共享数据时(不涉及到修改时不存在线程安全问题)
* 当多个线程在操作同一个共享数据时，一个线程对多条语句只执行了一部分，
* 还没有执行完，另一个线程参与进来执行,导致共享数据的错误
*
* 同步会使程序的执行效率降低，但是为了保证数据安全，必须加入线程同步机制；线程同步使程序变成了单线程
*
* 对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中，其他线程不可以参与执行
* */
public class Window8 implements Runnable {


    int ticket = 100;

    @Override
    public void run() {

        while(true){
            show();
        }
    }


    //同步方法实现线程安全，在多个线程的共享方法处用synchronized修饰，此处的锁为调用方法的当前对象，锁是唯一
    //继承Thread方式不能用此方式，或造成锁的不唯一性
    public synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.currentThread().sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "票号" + ticket);
            ticket--;
        }
    }
    public static void main(String[] args) {

        //创建三个线程
        Window8 window=new Window8();
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
