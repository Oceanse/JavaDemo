package com.demo.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
* corePoolSize和maximumPoolSize都是1，即SingleThreadPool只有一个核心线程，用唯一的工作线程来执行所有任务
* 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它
* 执行execute方法时，若当前运行的线程数未达到核心线程数（没有正在运行的线程），
* 就创建一个新线程来处理任务；如果当前有运行的线程，就把任务添加到阻塞队列LinkedBlockingQueue，其缓冲队列是无界的
* 线程执行完任务后，会反复从LinkedBlockingQueue获取任务来执行。
* SingleThreadPool线程池保证所有任务的执行顺序按照任务的提交顺序执行。
* */

public class SingleThreadPool {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {

            final int index=i;
            Runnable task=()->{
                System.out.println(Thread.currentThread().getName()+"执行第"+index+"任务");
            };

            executorService.execute(task);//从线程池取出一个线程处理task
            Thread.sleep(1000);//对于单线程来说在sleep时没有其他线程争抢cpu时间片，这里的sleep就像是一个定时器，线程处理完任务就sleep 1s

        }

        executorService.shutdown();//手动关闭线程池， 否则会一直在内存中存在
    }


}
