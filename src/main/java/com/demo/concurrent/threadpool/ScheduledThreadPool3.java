package com.demo.concurrent.threadpool;

import java.util.concurrent.*;
/*
* 主要用于给定 延时之后的运行任务或定期处理任务
* */


public class ScheduledThreadPool3 {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);//count初始值为3
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);


        /**
         * countDownLatch具有初始值属性的计时器锁，
         * countDownLatch类中只提供了一个构造器，参数count为计数值：public CountDownLatch(int count);
         */

        System.out.println("count初始值="+latch.getCount());
        Runnable task=()->{
            System.out.println(Thread.currentThread().getName()+"执行任务ing");
            latch.countDown();//每次调用CountDown()，count减1
        };



        scheduledExecutorService.scheduleAtFixedRate(task,3,1, TimeUnit.SECONDS);

        try {
            latch.await();//调用await()方法的线程(这里是主线程)会被挂起，它会等待直到count值为0才继续执行
            System.out.println("count值="+latch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
        System.out.println("我被执行");

    }



}
