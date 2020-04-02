package com.demo.concurrent.thread_safe;

public class Thread_Safe4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new B());
        Thread thread2 = new Thread(new B());

        thread.setName("t1");
        thread2.setName("t2");

        thread.start();

        Thread.sleep(1000);//1s之后下面这个线程才会启动，这样可以保证线程t1先启动执行

        thread2.start();
    }

}


class B implements  Runnable{

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            A.method1();
        }else {
            A.method2();
        }
    }
}

class A {

    /*method1 method2公用同一把类锁
    所以当一个线程握住锁执行其中一个方法时，另一个方法就不能被执行，同一把锁会同时锁住两个方法*/
    public synchronized static void method1() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1......");
    }

    public synchronized static void method2() {
        System.out.println("m2......");
    }
}
