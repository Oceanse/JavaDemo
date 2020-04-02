package com.demo.concurrent.threadpool;

/*
* ThreadPoolExecutor执行的策略:当一个任务被添加进线程池时：

线程数量未达到corePoolSize，则新建一个线程(核心线程)执行任务
线程数量达到了corePools，则将任务移入队列等待
队列已满，新建线程(非核心线程)执行任务
队列已满，总线程数又达到了maximumPoolSize，就会由上面那位星期天(RejectedExecutionHandler)抛出异常
* */

public class A {
    public static void main(String[] args) {
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();

        //向线程池内添加一个任务
        //threadPoolExecutor.execute(Runnable command);
    }
}
