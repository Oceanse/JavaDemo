package com.demo.concurrent.Sleep_Join_Yield;

public class ThreadSleep4 extends Thread {

    //如何正确的终止一个线程

    private boolean flag=true;

    @Override
    public void run() {//若flag==true 每隔1s打印一次

            for (int i = 0; i <100 ; i++) {
                if(flag){// if(run)放在for里面，不断检查run的状态
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
        //return;
    }

    public static void main(String[] args) throws InterruptedException {


        ThreadSleep4 threadDemo=new ThreadSleep4();
        threadDemo.setName("子线程");

        //启动子线程,会和后面并发执行
        threadDemo.start();


        Thread.sleep(5000);//主线程执行到这里会阻塞5s，5s之后,主线程解除阻塞，flag将设为false
        threadDemo.flag=false;




    }
}
