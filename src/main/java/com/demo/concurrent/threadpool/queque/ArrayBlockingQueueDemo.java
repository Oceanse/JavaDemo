package com.demo.concurrent.threadpool.queque;

/*
* ArrayBlockingQueue是一个基于数组的有界阻塞队列
* 有界也就意味着，它不能够存储无限多数量的对象，所以在创建 ArrayBlockingQueue 时，必须要给它指定一个队列的大小
* 如果向已满的队列继续塞入元素，将导致当前的线程阻塞。如果向空队列获取元素，那么将导致当前线程阻塞。
*
* add(E e)：把 e 加到 BlockingQueue 里，即如果 BlockingQueue 可以容纳，则返回 true，否则报异常
  offer(E e)：表示如果可能的话，将 e 加到 BlockingQueue 里，即如果 BlockingQueue 可以容纳，则返回 true，否则返回 false
  put(E e)：把 e 加到 BlockingQueue 里，如果 BlockQueue 没有空间，则调用此方法的线程被阻断直到 BlockingQueue 里面有空间再继续
  poll(time)：取走 BlockingQueue 里排在首位的对象，若不能立即取出，则可以等 time 参数规定的时间,取不到时返回 null
  take()：取走 BlockingQueue 里排在首位的对象，若 BlockingQueue 为空，阻断进入等待状态直到 Blocking 有新的对象被加入为止
  remainingCapacity()：剩余可用的大小。等于初始容量减去当前的 size
  ArrayBlockingQueue 使用场景。

 ArrayBlockingQueue 使用场景。
 先进先出队列（队列头的是最先进队的元素；队列尾的是最后进队的元素）
 有界队列（即初始化时指定的容量，就是队列最大的容量，不会出现扩容，容量满，则阻塞进队操作；容量空，则阻塞出队操作）
 队列不支持空元素

 * */

import org.testng.annotations.Test;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {

    @Test
    public void test() throws InterruptedException {
        // 我们创建了一个ArrayBlockingQueue，并且设置队列空间为2
        ArrayBlockingQueue<Object> arrayQueue = new ArrayBlockingQueue<Object>(2);
        arrayQueue.put(new Object());
        arrayQueue.put(new Object());
        System.out.println(arrayQueue.size());

        // 插入第三个对象时，这个操作线程就会被阻塞。
        arrayQueue.put(new Object());
    }

    @Test
    public void test2() throws InterruptedException {
        // 我们创建了一个ArrayBlockingQueue，并且设置队列空间为2
        ArrayBlockingQueue<Object> arrayQueue = new ArrayBlockingQueue<Object>(2);
        arrayQueue.put("a");
        arrayQueue.put("b");



        arrayQueue.take();
        arrayQueue.take();
        System.out.println(arrayQueue.size());

        arrayQueue.take();//队列为空时，take操作线程就会被阻塞,直到队列有新的元素被添加
    }




}
