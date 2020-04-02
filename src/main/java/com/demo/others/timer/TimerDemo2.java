package com.demo.others.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerDemo2 {
    private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        Timer timer = new Timer();

        //第一个参数是要操作的方法，第二个参数是要设定延迟的时间，第三个参数是周期的设定
        timer.schedule(new TimerTask() {
            public void run() {
                count.getAndIncrement();
                System.out.println(count);
            }
        }, 0 , 1000);
    }
}
