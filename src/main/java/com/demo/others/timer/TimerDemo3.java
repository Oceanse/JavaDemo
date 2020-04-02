package com.demo.others.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerDemo3 {
    private static AtomicInteger count = new AtomicInteger(0);
    private static CountDownLatch latch = new CountDownLatch(10);
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        //第一个参数是要操作的方法，第二个参数是要设定延迟的时间，第三个参数是周期的设定
        timer.schedule(new TimerTask() {
            public void run() {
                count.getAndIncrement();//每执行一次，count增1
                System.out.println(count);
                latch.countDown();//每执行一次，latch减1
            }
        }, 0 , 1000);

        latch.await();//调用await()方法的线程(这里是主线程)会被挂起，它会等待直到count值为0才继续执行
        timer.cancel();//当latch的count属性值等于0时候，主线程继续执行，timer.cancel()停止定时执行任务


    }
}
