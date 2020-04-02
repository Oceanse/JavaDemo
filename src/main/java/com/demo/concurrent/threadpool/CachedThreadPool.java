package com.demo.concurrent.threadpool;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如果当前没有空闲线程，当有新任务提交时，线该程池可以添加新线程来处理任务，但是如果有被使用完但是还没销毁的线程，就复用该线程
 * 如果线程池的大小(当前线程数)超过了处理任务所需要的线程数，那么空闲线程将会在指定时间内(默认60s)被回收
 * 工作线程的创建数量几乎没有限制(其实也有限制的,数目为Interger. MAX_VALUE)
 * 在使用CachedThreadPool时，一定要注意控制任务的数量，否则，由于大量线程同时运行，很有会造成系统瘫痪。
 * 这种线程池比较灵活，对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能
 */


public class CachedThreadPool {

    @Test
    public void test() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            final int index = i;
            //这里没有休眠控制，相当于瞬间提交了大量(大于1小于100)任务，因此线程池会在短时间内创建大量线程来处理任务
            //当继续有新的任务提交时，可能复用之前的线程，也可能会创建新的线程
            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(index + "当前线程" + Thread.currentThread().getName());
                }
            });
        }

    }



    @Test
    public void test2() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }//这行以上的代码还没涉及到多线程，都是单线程运行；sleep 1s相当于每一秒提交一个新任务，这样整段程序本质就是就是单线程运行；
            //可以发现10个线程都是使用的是同一线程，当第二个任务提交时，第一个任务已经完成，线程处于休闲状态，因此会复用执行第一个任务的线程，而不用每次新建线程。
            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(index + "当前线程" + Thread.currentThread().getName());
                }
            });
        }
        cachedThreadPool.shutdown();

    }


}
