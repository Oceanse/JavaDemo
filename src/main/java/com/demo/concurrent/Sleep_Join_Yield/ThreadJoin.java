package com.demo.concurrent.Sleep_Join_Yield;

public class ThreadJoin extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) {


        ThreadJoin threadDemo=new ThreadJoin();

        threadDemo.setName("子线程");
        Thread.currentThread().setName("主线程");

        //启动子线程1
        threadDemo.start();


        //主线程
        for (int i = 0; i <100 ; i++) {
            if(i==20){
                try {
                    /*
                    join() ：当某个线程B执行流中调用A线程的 join() 方法时，当前B线程由运行状态(Running)进入阻塞状态(BLOCKED)，直到 join() 方法加入的 join 线程执行完为止
                    线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
                    低优先级的线程也可以获得执行
                    * */
                    threadDemo.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
