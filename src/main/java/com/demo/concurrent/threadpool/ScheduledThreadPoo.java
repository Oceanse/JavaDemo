package com.demo.concurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/*
* 主要用于给定 延时之后的运行任务或定期处理任务
* */


public class ScheduledThreadPoo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        Runnable task=()->{
            System.out.println(Thread.currentThread().getName()+"执行任务ing");
        };

        //首次执行延期3s,之后每1s执行一次，时间单位是秒
        /**
         * 要执行的任务
         *  initialDelay 首次执行的延迟时间
         * delay 一次执行终止和下一次执行开始之间的延迟
         * initialDelay和delay参数的时间单位
         */
        scheduledExecutorService.scheduleAtFixedRate(task,0,1, TimeUnit.SECONDS);

    }


}
