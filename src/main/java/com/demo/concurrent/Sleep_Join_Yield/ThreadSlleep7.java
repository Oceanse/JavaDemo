package com.demo.concurrent.Sleep_Join_Yield;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 *  TimeUnit.SECONDS.sleep()是对Thread.sleep方法的包装，
 *  然而TimeUnit枚举成员的方法却提供更好的可读性通常用来替换Thread.sleep()
 *
 *  总结来说在你想用Thread.sleep()方法的地方你最好使用TimeUnit.sleep()方法来代替。
 *  它不尽可以提高代码的可读性而且能更加熟悉java.util.concurrent包，
 *  因为TimeUnit在并发编程中也是一个关键API。
 *
 */
public class ThreadSlleep7 {
    public static void main(String[] args) {

        //每隔1s打印一次
     /*   new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }).start();*/




        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }).start();


    }


    /**
     *
     * TimeUnit还提供了便捷方法用于把时间转换成不同单位，
     * 例如，如果你想把秒转换成毫秒，你可以使用下面代码：
     */
    @Test
    public void test() {
        System.out.println(TimeUnit.SECONDS.toMillis(44));
    }

}
