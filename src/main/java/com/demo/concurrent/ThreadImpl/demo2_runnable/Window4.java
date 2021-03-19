package com.demo.concurrent.ThreadImpl.demo2_runnable;

/*
lambda表达式可以构造函数型接口(接口里面只能有一个抽象方法)的实例对象,Runnable接口是函数型接口

@FunctionalInterface
public interface Runnable {
    public abstract void run();
}

public Thread(Runnable target){}
Thread构造函数接受Runnable接口类型的对象，所以这里必须要穿一个Runnable接口的实现类对象，
这个实现类本质就是重写Runnable接口里的抽象方法，而这个接口只有一个抽象方法，所以可以用lambda
表达式构造这个Runnable接口的对象

扩展：如果一个函数A接受的参数是函数形接口对象，那么可以用lambda表达式构造对象作为实参传给这个函数A
*/
public class Window4 {
    int ticket=100;

    public void sellTickets(){
        new Thread(()->{
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "票号" + ticket);
                ticket--;
            }
        }).start();

        new Thread(()->{
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "票号" + ticket);
                ticket--;
            }
        }).start();

        new Thread(()->{
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "票号" + ticket);
                ticket--;
            }
        }).start();
    }

    public static void main(String[] args) {
        new Window4().sellTickets();
    }

}
