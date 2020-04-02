package com.demo.concurrent.thread_safe;

public class Thread_Safe3 {
    public static void main(String[] args) throws InterruptedException {

        MyClass m=new MyClass();
        Process process=new Process(m);

        //两个线程共享同一个Myclass对象
        Thread thread = new Thread(process);
        Thread thread2 = new Thread(process);

        thread.setName("t1");
        thread2.setName("t2");

        thread.start();

        Thread.sleep(1000);//1s之后下面这个线程才会启动，这样可以保证线程t1先启动执行

        thread2.start();


    }


}


class Process implements Runnable{

    MyClass myClass;

    public Process(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {//线程体就是执行另一个类的对象的动作
        if (Thread.currentThread().getName().equals("t1")) {
            myClass.method1();
        }else {
            myClass.method2();
        }
    }
}


/*这里两个方法的锁都是当前Myclass对象, 两个线程共享同一个Myclass对象
所以当一个线程握住锁执行其中一个方法时，另一个方法就不能被执行，同一把锁会同时锁住两个方法*/

class MyClass{

    public synchronized void method1(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1......");

    }


    public synchronized void method2(){//若这里不加锁，这两个方法可以并发执行，也就是上面休眠过程中，这里可以被执行
        System.out.println("m2......");
    }
}
