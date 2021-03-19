package com.demo.concurrent.thread_safe.deadlock;

public class DeadLock2 {

    //整个程序中只有A锁和B锁， 两个线程共用相同的A锁和B锁
    public static void main(String[] args) {
        Runnable r1=()->{
            synchronized("A"){
                System.out.println("线程1持有A锁等待B锁");
                synchronized ("B"){
                    System.out.println("线程1持有A锁和B锁");
                }
            }
        };

        Runnable r2=()->{
            synchronized("B"){
                System.out.println("线程2持有B锁等待A锁");
                synchronized ("A"){
                    System.out.println("线程2持有A锁和B锁");
                }
            }
        };

        new Thread(r1).start();//当然如果某个线程能先执行完然后释放锁也不会导致死锁
        new Thread(r2).start();




    }
}
