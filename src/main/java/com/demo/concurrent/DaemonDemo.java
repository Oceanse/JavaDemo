package com.demo.concurrent;

/*
* JVM启动时会开启前台线程main线程和守护进程垃圾回收进程
*
*
* 后台线程主要是为其他线程（相对可以称之为前台线程）提供服务，如JVM中的垃圾回收线程。
*
* 后台线程的生命周期与前台线程生命周期有一定关联。主要体现在：
* 当所有的前台线程都进入死亡状态时，后台线程会自动死亡
* (其实这个也很好理解，因为后台线程存在的目的在于为前台线程服务的，
* 既然所有的前台线程都死亡了，那它自己还留着有什么用...伟大啊 ! !)
*
* */
public class DaemonDemo implements Runnable {


    public static void main(String[] args) throws InterruptedException {

        DaemonDemo daemonDemo = new DaemonDemo();
        Thread t = new Thread(daemonDemo);
        t.setName("t1");
        //调用setDeamon(true)方法将前台线程设置为后台线程时，需要在start()方法调用之前。
        //main线程都死亡后，JVM通知后台t1线程死亡
        t.setDaemon(true);
        t.start();


        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--->"+i);
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
