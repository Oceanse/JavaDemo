package com.demo.concurrent.Sleep_Join_Yield;

public class ThreadSleep extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i==50){
                    /*
                    Thread.sleep()是Thread类的一个静态方法，使当前线程休眠，由运行状态(Running)进入阻塞状态(BLOCKED)
                    线程阻塞通常是指一个线程在执行过程中暂停(放弃cpu使用权限)，以等待某个条件的触发
                    void  sleep(long millis)：(指定时间:毫秒)
                    令当前活动线程在指定时间段内放弃对CPU控制,进入阻塞状态，使其他线程有机会被执行,
                    sleep时间到后重新进入就绪状态。

                    sleep方法使用在线程体run中(main方法的方法体是主线程的线程体)，当某个线程对象执行线程体
                    的过程中遇到sleep,就会进入阻塞状态
                    * */
                try {
                    Thread.sleep(3000);//i=50时，当前线程放弃cpu 3s,此时其它线程就会抢到cpu时间片获得执行权
                } catch (InterruptedException e) {
                    e.printStackTrace();//Thread中的run方法没有抛异常，所以这里不能throws异常
                }
            }
            System.out.println(Thread.currentThread().getName()+"优先级："+Thread.currentThread().getPriority()+" i="+i);
        }
    }

    public static void main(String[] args) {



        ThreadSleep threadSleep=new ThreadSleep();
        threadSleep.setName("子线程");
        threadSleep.setPriority(7);
        threadSleep.start();//启动子线程,和后面的主线程并发执行，没有明确的先后顺序



        Thread.currentThread().setName("主线程");
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+"优先级："+Thread.currentThread().getPriority()+" i="+i);
        }
    }
}
