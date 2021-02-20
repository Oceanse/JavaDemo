package com.demo.concurrent.thread_safe;


public class Lock_Exception {

    //整个程序中只有A锁和B锁， 两个线程共用相同的A锁和B锁
    public static void main(String[] args) {
        Runnable r1=()->{
            synchronized("A"){
                System.out.println("线程1持有A锁等待B锁");
                System.out.println(1/0);//当线程执行这里时候会发生异常，线程抛出一个未捕获的Exception或Error将会死亡，然后就会释放同步锁，因此另一个线程就能抢到该锁
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

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
