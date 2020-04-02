package com.demo.concurrent.thread_safe;


public class Thread_Safe5 implements Runnable {



    //三个线程对象会抢占式执行这段线程体
    @Override
    public void run() {

        while(Tick.ticket>0){

            synchronized (this) {
                if(Tick.ticket<=0) return;
                System.out.println(Thread.currentThread().getName()+"票号"+Tick.ticket);
                Tick.ticket--;
            }
        }
    }

    public static void main(String[] args) {

        //创建三个线程
        Thread_Safe5 t=new Thread_Safe5();
        Thread thread=new Thread(t);
        Thread thread2=new Thread(t);
        Thread thread3=new Thread(t);

        //启动三个线程
        thread.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");


        thread.start();
        thread2.start();
        thread3.start();
    }
}


class Tick{
    static int ticket=100;//三个线程对象拥有着同一个Thread_Safe_cause对象，执行同一个线程体，共同修改同一份数据ticket
}