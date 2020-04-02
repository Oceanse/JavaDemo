package com.demo.concurrent.thread_safe;

/*

线程试图获得一个同步监视器，但该同步监视器(锁)正被其他线程所持有，锁申请操作是阻塞的，直到获得锁，进入就绪状态

* Java中死锁最简单的情况是，一个线程T1持有锁L1并且申请获得锁L2，
* 而另一个线程T2持有锁L2并且申请获得锁L1，因为默认的锁申请操作都是阻塞的，
* 所以线程T1和T2永远被阻塞了，导致了死锁
*
*
*实际环境中的死锁往往比这个复杂的多。可能会有多个线程形成了一个死锁的环路，
* 比如：线程T1持有锁L1并且申请获得锁L2，而线程T2持有锁L2并且申请获得锁L3，
* 而线程T3持有锁L3并且申请获得锁L1，这样导致了一个锁依赖的环路：T1依赖T2的锁L2，
* T2依赖T3的锁L3，而T3依赖T1的锁L1。从而导致了死锁。
*
*
*同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中
*
*
* */

public class DeadLock {
    public static void main(String[] args) {

        Object o1=new Object();
        Object o2=new Object();


        //两个线程共用相同的o1和o2，所有两个run方法内的o1与o1, o2与o2是同一个对象
        new Thread(new T1(o1,o2)).start();
        new Thread(new T2(o1,o2)).start();
    }
}

class T1 implements Runnable{
    Object o1;
    Object o2;

    public T1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    //线程需要握住两把对象锁o1和o2才能执行完线程体
    @Override
    public void run() {
        synchronized (o1){
            try {
                System.out.println("T1执行");
                Thread.sleep(1000);//休眠时对象锁o2被其它线程握住
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println("T1不执行");
            }
        }
    }
}


class T2 implements Runnable{
    Object o1;
    Object o2;

    public T2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }


    //线程需要握住两把对象锁o1和o2才能执行完线程体
    @Override
    public void run() {
        synchronized (o2){
            try {
                System.out.println("T2执行");
                Thread.sleep(1000);//休眠时对象锁o1被其它线程握住
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("T2不执行");
            }
        }

    }
}