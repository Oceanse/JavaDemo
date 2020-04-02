package com.demo.concurrent.threadpool;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPool {

    /*
      定长线程池，可控制线程最大并发数，
      核心线程数等于最大线程数，所以线程全部创建完成后就会一直存在于线程池，所以使用完毕必须手动关闭线程池(否则会一直在内存中)
      如果线程池的数量达到了指定数量，并且有线程是空闲的，则取出空闲线程执行任务
      如果没有线程是空闲的，则将任务缓存到队列（队列长度为Integer.MAX_VALUE）。
      当线程空闲的时候，按照FIFO的方式进行处理
    * */


    @Test
    public void test() throws InterruptedException {
        /*
        * 如果线程池的当前大小还没有达到基本大小(poolSize < corePoolSize)，
        * 那么就启动一个新的线程处理新提交的任务，即使有空闲的线程；
        * 5个线程处理5个任务，这里每当有一个新请求，从线程池中启动一个新的线程处理新提交的任务，所以这里5个任务和5个线程一一对应
        * */
        ExecutorService executorService=Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            final int index=i;
            Runnable task=()->{
                System.out.println(Thread.currentThread().getId()+"执行任务"+index);
            };
            executorService.execute(task);//任务数量等于核心线程数，所以线程和任务一一对应
            //Thread.sleep(1000);

        }
        executorService.shutdown();//手动关闭线程池，否则核心线程会一直在等待任务，处于阻塞状态
        System.out.println(((ThreadPoolExecutor) executorService).getPoolSize());

    }
    @Test
    public void test2() throws InterruptedException {
        ExecutorService executorService=Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {//当任务数量多余线程数量,可以理解为五个线程瞬间被创建好，谁空闲，谁去执行任务
            final int index=i;
            Runnable task=()->{
                System.out.println(Thread.currentThread().getId()+"执行任务"+index);};

            executorService.execute(task);//从线程池取出一个新线程处理task
            Thread.sleep(1000);

        }
        executorService.shutdown();//关闭线程池

    }

    @Test
    public void test3() throws InterruptedException{
        ExecutorService executorService=Executors.newFixedThreadPool(5);
        //(ThreadPoolExecutor)executorService.getActiveCount();

    }


}
