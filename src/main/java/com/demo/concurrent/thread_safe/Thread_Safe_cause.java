package com.demo.concurrent.thread_safe;


/*
* 当多个线程在操作同一个共享数据时，一个线程对多条语句只执行了一部分，
* 还没有执行完，另一个线程参与进来执行，导致共享数据的错误
* 对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中，其他线程不可以参与执行
*在不同的地方发生阻塞会产生不同的错误结果，所以加锁的时候一定注意同步代码块的范围
*
* */
public class Thread_Safe_cause implements Runnable {

    //三个线程对象拥有着同一个Thread_Safe_cause对象，执行同一个线程体，共同修改同一份数据ticket
    int ticket = 100;

    //三个线程对象会抢占式执行这段线程体
    @Override
    public void run() {

        while(ticket>0){
            try {
              /*

              假设当前ticket=100,三个线程可能依次执行完打印这一步后都失去cpu阻塞，所以会打印出三张ticket=100的重票；
              如果最后还剩一张票ticket=1，三个线程可能执行完while(ticket>0)，由于sleep,然后都失去cpu一段时间阻塞在这一步，然后依次执行完毕，所以会打印出1,0，-1，两张错票
                */
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"票号"+ticket);
            ticket--;
        }
    }

    public static void main(String[] args) {

        //创建三个线程
        Thread_Safe_cause window=new Thread_Safe_cause();
        Thread thread=new Thread(window);
        Thread thread2=new Thread(window);
        Thread thread3=new Thread(window);

        //启动三个线程
        thread.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");


        thread.start();
        thread2.start();
        thread3.start();
    }
}
