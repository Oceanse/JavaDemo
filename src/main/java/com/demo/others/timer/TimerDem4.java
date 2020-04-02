package com.demo.others.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDem4 {
    public static void main(String[] args) {
        Timer timer = new Timer();

        //   第一个参数是要操作的方法，第二个参数是要设定延迟的时间，第三个参数是周期的设定
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("aaa");
            }
        }, 0 , 1000);


        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("bbb");
            }
        }, 0 , 1000);


    }
}
