package com.demo.others;

import org.springframework.util.StopWatch;
import org.testng.annotations.Test;


/**
 * StopWatch是位于org.springframework.util包下的一个工具类，通过它可方便的对程序部分代码进行计时(ms级别)，适用于同步单线程代码块。
 *
 *  StopWatch sw = new StopWatch("test");
 *      sw.start("task1");
 *      // do something
 *     sw.stop();
 *
 *     sw.start("task2");
 *     // do something
 *     sw.stop();
 *
 *     System.out.println(sw.prettyPrint());
 */
public class StopwatchDemo {

    @Test
    public static void test() throws InterruptedException {
        StopWatch sw = new StopWatch("test");
        sw.start("task1");
        print();
        sw.stop();
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.prettyPrint());
    }

    public static void print(){
        for (int i = 0; i < 10; i++) {
            System.out.println("i="+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
