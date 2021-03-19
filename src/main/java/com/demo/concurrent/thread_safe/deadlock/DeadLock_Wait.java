package com.demo.concurrent.thread_safe.deadlock;

/*
* 运行的线程执行wait()方法，该线程会释放线程占有的同步锁，JVM会把该线程放入“等待池”中,该线程进入阻塞状态。进入这个状态后，
* 该线程是不能自动唤醒的，必须依靠其他线程调用notify()或notifyAll()方法才能被唤醒，
*
* wait()使当前线程阻塞，前提是 必须先获得锁，一般配合synchronized 关键字使用，
* 即，一般在synchronized 同步代码块里使用 wait()、notify/notifyAll() 方法。
* */

public class DeadLock_Wait {

    //整个程序中只有A锁和B锁， 两个线程共用相同的A锁和B锁
    public static void main(String[] args) {
        Runnable r1=()->{
            synchronized("A"){
                System.out.println("线程1持有A锁等待B锁");
                try {
                    //"C".wait();当前线程并没有持有"C"锁，调用wait方法会抛出异常
                    "A".wait();//该线程释放"A"锁，进入阻塞状态;持有锁，才能调用wait方法释放同步锁并进入阻塞状态；由于没有其他线程唤醒，当前线程就会一直处于阻塞状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized ("B"){
                    System.out.println("线程1持有A锁和B锁");
                }
            }
        };

        Runnable r2=()->{
            synchronized("B"){
                System.out.println("线程2持有B锁等待A锁");
                synchronized ("A"){//当前线程可以获得其他线程释放的"A"锁
                    System.out.println("线程2持有A锁和B锁");
                }
            }
        };

        new Thread(r1).start();//当然如果某个线程能先执行完然后释放锁也不会导致死锁
        new Thread(r2).start();




    }
}
