package com.demo.others;

import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * 我们知道基本类型的赋值操作是原子操作，但是类似这种i++的操作并不是原子操作，通过反编译代码我们可以大致了解此操作分为三个阶段：
 * tp1 = i;  //1
 * tp2 = tp1 + 1;  //2
 * i = tp2;  //3
 * 如果有两个线程m和n要执行i++操作，因为重排序的影响，代码执行顺序可能会发生改变。
 * 如果代码的执行顺序是m1 - m2 - m3 - n1 - n2 - n3，那么结果是没问题的，
 * 如果代码的执行顺序是m1 - n1 - m2 - n2 - m3 - n3那么很明显结果就会出错。
 */
public class AtomicIntegerDemo {

    public static int count = 0;
    private static AtomicInteger count2 = new AtomicInteger(0);

    public static void increase() {
        count++;
    }


    public static void increase2() {
        count2.getAndIncrement();
    }

    @Test
    public void test(){

    }


    @Test
    public static void test2(){
        for (int i = 0; i <10 ; i++) {
            count2.getAndIncrement();
            System.out.println(count2);
        }
    }

    @Test
    public static void test3(){
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        count2.getAndIncrement();
                    }
                }
            }).start();
        }
        System.out.println(count2);
    }


    public static void main(String[] args) {
      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increase();
                }
            }
        }).start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count++;
                }
            }
        }).start();

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(count);
    }



}
