package com.demo.concurrent.threadpool;
/*


重用存在的线程，减少对象创建、消亡的开销，性能佳。
可有效控制最大并发线程数，提高系统资源的使用率，同时避免过多资源竞争，避免堵塞。
提供定时执行、定期执行、单线程、并发数控制等功能。

线程池的好处:
一定要注意一个概念，即存在于线程池中容器的一定是Thread对象，而不是您要求运行的任务（所以叫线程池而不叫任务池也不叫对象池，更不叫游泳池）；
您要求运行的任务将被线程池分配给某一个空闲的Thread运行。

 * */

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        //test();
        //test2();
        //test1();
        //test2_2();
        //test3();
        //test4();
        //test5();
        //test6();
        //test7();
        test8();

       /* t.execute(new Thread(new Task()));
        t.execute(new Thread(new Task2()));
        t.execute(new Thread(new Task3()));
        System.out.println(t.getPoolSize());
        t.shutdown();*/
    }


    public static void test() {

        ThreadPoolExecutor t = new ThreadPoolExecutor(3, 4, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));
        System.out.println(t.getPoolSize());//在创建了线程池后，默认情况下，线程池中并没有任何线程
    }

    public static void test1() {

        ThreadPoolExecutor t = new ThreadPoolExecutor(3, 4, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));
        t.prestartAllCoreThreads();//在创建了线程池后，默认情况下，线程池中并没有任何线程,prestartAllCoreThreads设置项，可以在线程池创建，但还没有接收到任何任务的情况下，先行创建符合corePoolSize参数值的线程数：
        System.out.println(t.getPoolSize());
        //新创建的核心线程一直处于空闲状态等待新的任务提交，没有空闲超时策略，所以如果不手动关闭线程池，程序会一致处于阻塞状态
    }


    public static void test2() {

        ThreadPoolExecutor t = new ThreadPoolExecutor(3, 4, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));

        //线程池创建了三个线程执行任务，当前线程数<=核心线程数，那么就启动一个新的线程处理新提交的任务，即使有空闲的线程,所以下面每个任务都是对应新的线程
        // 我理解为即使之前的核心线程执行完任务处于空闲状态，但是当有新的任务时，仍然会创建新的线程执行这个任务，最终线程池中的线程数poolSize逐渐达到核心线程数corePoolSize)
        t.execute(new Thread(new Task()));
        t.execute(new Thread(new Task2()));
        t.execute(new Thread(new Task3()));
        System.out.println(t.getPoolSize());
        //线程执行完后核心线程会一直处于空闲状态等待新的任务提交，没有空闲超时策略，所以如果不手动关闭线程池，程序会一致处于阻塞状态

    }

    public static void test2_2() {

        ThreadPoolExecutor t = new ThreadPoolExecutor(3, 4, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));

        //闲置的核心线程会有超时策略，这个时间由keepAliveTime来设定，所以当多余任务执行完，所有线程过了keepAliveTime后全部被销毁，程序不会阻塞
        t.allowCoreThreadTimeOut(true);

        //线程池创建了三个线程执行任务，当前线程数<=核心线程数，那么就启动一个新的线程处理新提交的任务，即使有空闲的线程,所以下面每个任务都是对应新的线程
        // 我理解为即使之前的核心线程执行完任务处于空闲状态，但是当有新的任务时，仍然会创建新的线程执行这个任务，最终线程池中的线程数poolSize逐渐达到核心线程数corePoolSize)
        t.execute(new Thread(new Task()));
        t.execute(new Thread(new Task2()));
        t.execute(new Thread(new Task3()));
        System.out.println(t.getPoolSize());

    }


    public static void test3() {

        ThreadPoolExecutor t = new ThreadPoolExecutor(3, 4, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));

        //线程池放入了5个任务，那么所有的3个核心线程会全部被创建，当前任务数>核心线程数，此时不会创建新的非核心线程，多余的任务提交到阻塞队列排队
        //当前线程池只有三个线程
        t.execute(new Thread(new Task()));
        t.execute(new Thread(new Task2()));
        t.execute(new Thread(new Task3()));
        t.execute(new Thread(new Task4()));
        t.execute(new Thread(new Task4()));
        System.out.println(t.getPoolSize());
    }

    public static void test4() {

        ThreadPoolExecutor t = new ThreadPoolExecutor(3, 6, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));

        //线程池放入了8个任务，那么所有的3个核心线程会全部被创建处理三个任务，任务队列存放3个任务已满，
        //于是线程池会创建新的线程，但是会保证当前线程数小于最大线程数
        t.execute(new Thread(new Task()));
        t.execute(new Thread(new Task2()));
        t.execute(new Thread(new Task3()));
        t.execute(new Thread(new Task4()));
        t.execute(new Thread(new Task4()));
        t.execute(new Thread(new Task4()));
        t.execute(new Thread(new Task4()));
        t.execute(new Thread(new Task4()));
        System.out.println(t.getPoolSize());//在创建了线程池后，默认情况下，线程池中并没有任何线程
    }


    public static void test5() {

        ThreadPoolExecutor t = new ThreadPoolExecutor(3, 6, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));

        //线程池放入了10个任务，那么所有的3个核心线程会全部被创建处理三个任务，任务队列存放3个任务已满，还有任务提交时
        //线程池会创建新的线程，当当前线程数量达到最大数量，还有任务进来而又没有空闲的线程处理，此时就会产生异常
        for (int i = 0; i < 10; i++) {
            t.execute(new Thread(new Task()));
        }
    }

    public static void test6() {

        ThreadPoolExecutor t = new ThreadPoolExecutor(3, 4, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));
        t.shutdown();//这里线程池刚被创建时并没有任何线程，如果刚创建完就关闭，会导致下面的代码产生RejectedExecutionException异常
        t.execute(new Thread(new Task()));
        t.execute(new Thread(new Task2()));
        t.execute(new Thread(new Task3()));
        System.out.println(t.getPoolSize());

       /* 当线程池调用该方法时,线程池的状态则立刻变成SHUTDOWN状态,此时空闲线程将会被销毁，正在执行的任务的线程会继续工作，
        此时，则不能再往线程池中添加任何任务，否则将会抛出RejectedExecutionException异常，
        此时线程池直到等到线程池中的任务都已经处理完成，才会退出。

        shutdown的过程就是逐渐销毁所有对象的一个过程
        */
        //t.shutdown();

    }

    public static void test7() {

        ThreadPoolExecutor t = new ThreadPoolExecutor(3, 4, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));
        t.prestartAllCoreThreads();//预先创建所有核心线程
        t.shutdown();//这里线程池刚被创建时虽然会创建所有核心线程，但是所有核心线程都处于空闲状态，如果此时关闭线程池，也就会销毁所有线程对象，会导致下面的代码产生RejectedExecutionException异常
        t.execute(new Thread(new Task()));
        t.execute(new Thread(new Task2()));
        t.execute(new Thread(new Task3()));
        System.out.println(t.getPoolSize());

       /* 当线程池调用该方法时,线程池的状态则立刻变成SHUTDOWN状态,此时空闲线程将会被销毁，正在执行的任务的线程会继续工作，
        此时，则不能再往线程池中添加任何任务，否则将会抛出RejectedExecutionException异常，
        此时线程池直到等到线程池中的任务都已经处理完成，才会退出。*/
        //t.shutdown();

    }

    public static void test8() {

        ThreadPoolExecutor t = new ThreadPoolExecutor(3, 4, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));
        t.prestartAllCoreThreads();//预先创建所有核心线程
        t.execute(new Thread(new Task5()));
        t.execute(new Thread(new Task5()));
        t.execute(new Thread(new Task5()));

       /* 当线程池调用该方法时,线程池的状态则立刻变成SHUTDOWN状态,此时空闲线程将会被销毁，正在执行的任务的线程会继续工作，
        此时，则不能再往线程池中添加任何任务，否则将会抛出RejectedExecutionException异常，
        此时线程池直到等到线程池中的任务都已经处理完成，才会退出。*/

        System.out.println("befor" + t.getPoolSize());
        t.shutdown();
        System.out.println("after" + t.getPoolSize());//在执行这行代码时候，所有线程可能还都在工作，都没有被销毁，所以结果可能是3
    }




}


class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "task");

    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "tesk2");

    }
}


class Task3 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "tesk3");

    }
}


class Task4 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "tesk4");

    }
}


class Task5 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " task5");
        }

    }
}