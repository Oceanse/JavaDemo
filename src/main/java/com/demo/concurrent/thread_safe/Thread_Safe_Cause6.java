package com.demo.concurrent.thread_safe;

/*
 * 懒汉式单例模式：当有多个线程时候可能存在线程安全问题，导致产生多个对象
 * */
public class Thread_Safe_Cause6 {

    private static Thread_Safe_Cause6 t = null;

    private Thread_Safe_Cause6() {
        System.out.println("新建一个Thread_Safe_Cause6对象");
    }

    public static Thread_Safe_Cause6 getInstance() {
        if (t == null) {//可能会有多个进程进入到if里面，然后阻塞住
            t = new Thread_Safe_Cause6();
        }
        return t;
    }

    public static Thread_Safe_Cause6 getInstanceSafe() {
        synchronized ("") {//线程安全
            if (t == null) {
                t = new Thread_Safe_Cause6();
            }
        }
        return t;
    }

}


class Test {
    public static void main(String[] args) {
        Runnable r = () -> {
            Thread_Safe_Cause6.getInstance();
        };
        Runnable r2 = () -> {
            Thread_Safe_Cause6.getInstanceSafe();
        };

        for (int i = 0; i < 10; i++) {
            new Thread(r2).start();
        }
    }
}
