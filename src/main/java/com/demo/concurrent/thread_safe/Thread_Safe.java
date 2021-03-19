package com.demo.concurrent.thread_safe;


/*
* 当多个线程在操作同一个共享数据时，一个线程对多条语句只执行了一部分，
* 还没有执行完，另一个线程参与进来执行。导致共享数据的错误
*
* 由此我们想到一个解决的思路：将操作共享数据的代码行作为一个整体，
* 同一时间只允许一个线程执行，执行过程中其他线程不能参与执行
*
*  synchronized (对象锁){//锁可以是任意Java对象，但是要唯一的
     //需要同步的代码
 }

* 由对象充当同步监视器，也称之为锁,锁对于所有线程必须要保证唯一,也就是所有线程对象共享一把锁
* 同一时刻，只能一个线程对象拥有锁，然后将synchronized的代码块锁住，拥有锁的线程才能去执行
* 拥有锁的线程在执行同步代码块期间，其它线程都不能执行这段代码
* 拥有锁的线程执行完代码就会释放锁；其他的线程要等待这个线程将锁释放后才可以获取到这个锁想
* 然后下一个握住锁的线程才可以去执行同步代码块
*
* 对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中，其他线程不可以参与执行
* */
public class Thread_Safe implements Runnable {


    int ticket = 100;

    //由对象充当同步监视器，也称之为锁,锁对于所有线程必须要保证唯一
    //多个线程对象共用一个Runnable接口实现类,所以object是唯一的
    Object object=new Object();
    @Override
    public void run() {

        while(true){
            //对下面代码块加锁，线程体执行到这就会握住这把锁，锁定同步代码块，直达执行完毕才会释放锁，下个线程执行到这握住锁。。。。。
            //this是指Thread_safe对象，这里多个线程共享同一个Thread_safe对象，所以this对象可以保证锁的唯一性，因此这里可以用this
            //若是采用继承继承Thread方式创建多线程，不能用this
            synchronized (object) { //由对象充当同步监视器，也称之为锁，哪个线程获取锁，哪个线程就执行大括号里被同步的代码块
                if (ticket > 0) {
                    try {
                        //当前线程休眠（释放cpu）20 ms, 其它线程就会执行此段代码，若没有采取同步等安全措施，容易导致线程安全问题(大概率出现负数票)
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "票号" + ticket);//这一句和下面ticket--执行时候存在时间差，若没有采取同步等安全措施，可能会出现重票
                    ticket--;
                }
            }
        }
    }

    public static void main(String[] args) {

        //创建三个线程
        Thread_Safe window=new Thread_Safe();
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
