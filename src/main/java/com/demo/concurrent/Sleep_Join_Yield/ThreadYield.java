package com.demo.concurrent.Sleep_Join_Yield;

public class ThreadYield extends Thread {

               /*  yield()：线程让步，释放当前cpu, 但是与sleep不同的是线程由运行状态(Running)进入就绪状态(RUNNABLE)
                    yield释放当前cpu,暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程，包括他自己
                    让自己或者其它的线程运行，注意是让自己或者其他线程运行，并不是单纯的让给其他线程。
                     yield()的作用是让步。它能让当前线程由“运行状态”进入到“就绪状态”，从而让其它具有相同优先级的等待线程获取执行权；
                     但是，并不能保证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权；
                     也有可能是当前线程又进入到“运行状态”继续运行！
                    若队列中没有同优先级的线程，忽略此方法

                */

    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            if(i==3){  //i==10时候，当前线程让出cpu进入就绪状态，下一刻当前线程和主线程重新抢占cpu时间片
                Thread.currentThread().yield();
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) {


        ThreadYield threadDemo=new ThreadYield();
        ThreadYield threadDemo2=new ThreadYield();

        threadDemo.setName("线程1");
        threadDemo2.setName("线程2");

        threadDemo.start();
        threadDemo2.start();

    }
}
