package com.demo.concurrent.threadpool.queque;

import org.testng.annotations.Test;

import java.util.concurrent.*;

public class LinkedBlockingQueueDemo {
/*
* BlockingQueue即阻塞队列
* BlockingQueue是一个接口，它的实现类有ArrayBlockingQueue、DelayQueue、 LinkedBlockingDeque、
* LinkedBlockingQueue、PriorityBlockingQueue、SynchronousQueue等，
* 它们的区别主要体现在存储结构上或对元素操作上的不同，但是对于take与put操作的原理，却是类似的。
*
* LinkedBlockingQueue是我们在ThreadPoolExecutor线程池中常应用的等待队列。它可以指定容量也可以不指定容量。
* 由于它具有“无限容量”的特性，所以我还是将它归入了无限队列的范畴（实际上任何无限容量的队列/栈都是有容量的，这个容量就是Integer.MAX_VALUE）
*
* 如果您指定了LinkedBlockingQueue的容量大小，那么它反映出来的使用特性就和ArrayBlockingQueue类似了
*
*
*LinkedBlockingQueue中维持两把锁，一把锁用于入队，一把锁用于出队，这也就意味着，同一时刻，
* 只能有一个线程执行入队，其余执行入队的线程将会被阻塞；同时，可以有另一个线程执行出队，
* 其余执行出队的线程将会被阻塞。换句话说，虽然入队和出队两个操作同时均只能有一个线程操作，
* 但是可以一个入队线程和一个出队线程共同执行，也就意味着可能同时有两个线程在操作队列，那么为了维持线程安全，
*


* */

    @Test
    public void test() {
        //有界队列
        BlockingQueue bq=new LinkedBlockingDeque(3);
        bq.add("aa");
        bq.add("bb");
        bq.add("cc");
        bq.add("dd");//产生异常
    }

    @Test
    public void test2() {
        //有界队列
        BlockingQueue bq=new LinkedBlockingDeque(3);
        bq.offer("aa");
        bq.offer("bb");
        bq.offer("cc");
        boolean dd = bq.offer("dd");//返回false,但不会产生异常
    }

    @Test
    public void test3() throws InterruptedException {
        //有界队列
        BlockingQueue bq=new LinkedBlockingDeque(3);
        bq.offer("aa");
        bq.offer("bb");
        bq.offer("cc");


        long start=System.currentTimeMillis();
        //Inserts the specified element into this queue, waiting up to the
        //specified wait time if necessary for space to become available.
        boolean dd = bq.offer("dd",3, TimeUnit.SECONDS);//这里会给这行代码最长3s的时间去完成，比如队列man时，这3s在等待队列中出现新的空间，但是队列没满时，就可马上入队
        long end =System.currentTimeMillis();
        System.out.println(end-start);
    }


    @Test
    public void test4() throws InterruptedException {
        //有界队列
        BlockingQueue bq=new LinkedBlockingDeque(4);
        bq.offer("aa");
        bq.offer("bb");
        bq.offer("cc");


        long start=System.currentTimeMillis();
        //Inserts the specified element into this queue, waiting up to the
        //specified wait time if necessary for space to become available.
        boolean dd = bq.offer("dd",3, TimeUnit.SECONDS);//这里会给这行代码最长3s的时间去完成，比如队列man时，这3s在等待队列中出现新的空间，但是队列没满时，就可马上入队
        long end =System.currentTimeMillis();
        System.out.println(end-start);
    }

    /*@Test
    public void test3() {
        //有界队列
        BlockingQueue bq=new LinkedBlockingDeque(3);
        bq.add("aa");
        bq.add("bb");
        bq.add("cc");

        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.size());

        System.out.println();
        System.out.println(bq.poll());
        System.out.println(bq.size());
    }
*/

    @Test
    public void test5() throws InterruptedException {
        BlockingQueue bq=new LinkedBlockingDeque(2);
        bq.put(new Object());
        bq.put(new Object());
        System.out.println(bq.size());

        // 插入第三个对象时，这个操作线程就会被阻塞。
        bq.put(new Object());
    }


    @Test
    public void test5_2() throws InterruptedException {

        //没有指定容量就是一个无界队列
        BlockingQueue bq=new LinkedBlockingDeque();
        bq.put(new Object());
        bq.put(new Object());
        bq.put(new Object());
    }



    @Test
    public void test6() throws InterruptedException {
        BlockingQueue bq=new LinkedBlockingDeque(2);
        bq.put(new Object());
        bq.put(new Object());
        System.out.println(bq.size());

        bq.take();
        bq.take();
        System.out.println(bq.size());
        bq.take();
    }

    }
