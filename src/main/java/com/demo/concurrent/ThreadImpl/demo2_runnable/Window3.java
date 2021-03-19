package com.demo.concurrent.ThreadImpl.demo2_runnable;


/**
  创建Runnalble接口匿名实现类对象直接传给New Thread(Runnalble r).start(),这样使得代码更加简洁

 匿名实现类对象语法：
   new 接口名（）{
       重写接口方法
       }
*/
public class Window3 {

    //三个线程共享一个对象的变量
     int ticket = 100;




    public static void main(String[] args) {
        new Window3().test();

    }

    //test()方法的当前对象是是main方法中的new Window3()，所以test()方法中所有的ticket变量都是同一个对象的ticket变量
    public void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"票号"+ticket);//这一句和下面ticket--执行时候存在时间差，所以可能会出现重票
                    ticket--;
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"票号"+ticket);//这一句和下面ticket--执行时候存在时间差，所以可能会出现重票
                    ticket--;
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"票号"+ticket);//这一句和下面ticket--执行时候存在时间差，所以可能会出现重票
                    ticket--;
                }
            }
        }).start();
    }
}
