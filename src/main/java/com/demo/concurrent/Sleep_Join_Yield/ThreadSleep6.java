package com.demo.concurrent.Sleep_Join_Yield;

public class ThreadSleep6 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //main方法整个方法体都是主线程的线程体


        /*
        * 调用线程对象的start()方法之后，该线程立即进入就绪状态——就绪状态相当于"等待执行"，但该线程并未真正进入运行状态。
        假设现在有一个主线程和一个子线程，我们希望调用子线程的start()方法后子线程立即开始执行，程序可以使用Thread.sleep(10)
        来让当前运行的线程（主线程）睡眠10毫秒，因为在这10毫秒内CPU不会空闲，它会去执行另一个处于就绪状态的线程，
        这样就可以让子线程立即开始执行
        * */

        System.out.println("猪猪猪猪");//jvm默认启动主线程，主线程执行到这还没有开启新线程
        Thread.currentThread().setName("主线程");
        ThreadSleep6 threadDemo=new ThreadSleep6();
        threadDemo.setName("子线程");
        threadDemo.start();//从这里开始，子线程和后面主线程的的代码并发执行，争抢cpu时间片
        Thread.sleep(10); //使当前线程(主线程)休眠，进入阻塞状态，CPU不会空闲，它会去执行另一个处于就绪状态的线程


        //主线程代码
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
