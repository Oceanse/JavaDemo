package com.demo.concurrent.ThreadImpl;

import org.testng.annotations.Test;

public class ThreadName {

    public static void main(String[] args) {

    }


    @Test
    public void test(){
        Thread t = new Thread("子线程");//实例化线程对象时命名
        System.out.println(t.getName());
    }

    @Test
    public void test2(){
        T t = new T("子线程");//实例化线程对象时命名
        t.start();
    }

    @Test
    public void test3(){
        Thread t = new Thread();
        t.setName("子线程");
        System.out.println(t.getName());
    }

    @Test
    public void test4(){
        Thread t = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        t.setName("子线程");
        t.start();
    }

    @Test
    public void test5(){
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        };

        //public Thread(Runnable target, String threadName)
        Thread t = new Thread(r, "子线程");//实例化线程对象时命名
        t.start();
    }

}


class T extends Thread{
    public T(String name) {
        super(name);

        //this.setName(name);亦可
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}