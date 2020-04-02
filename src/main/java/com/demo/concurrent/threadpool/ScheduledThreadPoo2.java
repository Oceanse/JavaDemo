package com.demo.concurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/*
* 主要用于给定 延时之后的运行任务或定期处理任务
* */


public class ScheduledThreadPoo2 {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        System.out.println("a="+((ThreadPoolExecutor) scheduledExecutorService).getPoolSize());
        Runnable task=()->{
            System.out.println(Thread.currentThread().getName()+"执行任务ing");
        };
        System.out.println("b="+((ThreadPoolExecutor) scheduledExecutorService).getPoolSize());

        //首次执行延期3s,之后每1s执行一次，时间单位是秒
        /**
         * 要执行的任务
         *  initialDelay 首次执行的延迟时间
         * delay 一次执行终止和下一次执行开始之间的延迟
         * initialDelay和delay参数的时间单位
         */
        scheduledExecutorService.scheduleAtFixedRate(task,0,1, TimeUnit.SECONDS);
        System.out.println("c="+((ThreadPoolExecutor) scheduledExecutorService).getPoolSize());

        /**
         * 当线程池调用该方法时,线程池的状态则立刻变成SHUTDOWN状态,此时空闲线程将会被销毁，正在执行的任务的线程会继续工作
         * 这里如果调用shutdown方法会导致所有任务都不能被执行,貌似是所有线程对象还没执行任务时就被销毁
         */
        //Thread.sleep(1000);
        scheduledExecutorService.shutdown();
    }


}
